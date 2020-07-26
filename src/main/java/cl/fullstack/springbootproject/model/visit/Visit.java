package cl.fullstack.springbootproject.model.visit;

import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.model.user.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Visit {
    @Id
    @GeneratedValue(generator = "VISIT_SEQ")
    private Long id;

    private boolean ready; // State of visit
    private Date schedulingDate; // When visit should be done
    private Date finishDate; // When visit was done

    // Associations

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonIgnore
    private Customer customer;

    @OneToOne(mappedBy = "visit", cascade = CascadeType.ALL, optional = false)
    @JsonIgnore
    private Summary summary;

    @OneToOne(mappedBy = "visit", cascade = CascadeType.ALL, optional = false)
    @JsonIgnore
    private Payment payment;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "EMPLOYEE_ID")
    @JsonIgnore
    private Employee employee;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Activity> activities;

    public void addActivity(Activity activity) {
        if (activities == null) activities = new ArrayList<>();
        activities.add(activity);
        activity.setVisit(this);
    }

    // Automatic functions

    @PreUpdate
    private void autoUpdateReadyDate() {
        if (ready) {
            if (finishDate == null) finishDate = new Date();
        } else {
            finishDate = null;
        }
    }

    @PrePersist
    private void autoSetReadyFalse() {
        ready = false;
    }
}
