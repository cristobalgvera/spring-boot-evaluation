package cl.fullstack.springbootproject.model.visit;

import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.model.user.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Visit extends AbstractAuditable<Employee, Long> {

    private boolean ready; // State of visit
    private LocalDateTime schedulingDate; // When visit should be done
    private LocalDateTime finishDate; // When visit was done

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

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    @JsonIgnore
    private Address address;

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
    private void whenUpdate() {
        if (ready) {
            if (finishDate == null) finishDate = LocalDateTime.now();
        } else {
            finishDate = null;
        }
        setLastModifiedBy(getEmployee());
        setLastModifiedDate(LocalDateTime.now());
    }

    @PrePersist
    private void whenCreate() {
        setReady(false);
        setCreatedBy(getEmployee());
        setCreatedDate(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Visit{" +
                super.toString() +
                ", ready=" + ready +
                ", schedulingDate=" + schedulingDate +
                ", finishDate=" + finishDate +
                ", customer=" + customer.getId() +
                ", summary=" + summary +
                ", payment=" + payment +
                ", employee=" + employee.getId() +
                ", address=" + address +
                ", activities=" + activities +
                '}';
    }
}
