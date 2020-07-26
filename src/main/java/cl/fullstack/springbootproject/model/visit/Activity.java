package cl.fullstack.springbootproject.model.visit;

import cl.fullstack.springbootproject.model.visit.Visit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Activity {
    @Id
    @GeneratedValue(generator = "ACTIVITY_SEQ")
    private Long id;

    private String description; // JTBD
    private boolean ready; // State of activity
    private Date schedulingDate; // When activity should be done
    private Date readyDate; // When activity is done

    // Associations

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "VISIT_ID")
    @JsonIgnore
    private Visit visit;

    // Automatic functions

    @PreUpdate
    private void autoUpdateReadyDate() {
        if (ready) {
            if (readyDate == null) readyDate = new Date();
        } else {
            readyDate = null;
        }
    }

    @PrePersist
    private void autoSetReadyFalse() {
        ready = false;
    }
}
