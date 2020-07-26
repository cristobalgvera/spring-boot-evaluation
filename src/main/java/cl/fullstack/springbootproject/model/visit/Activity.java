package cl.fullstack.springbootproject.model.visit;

import cl.fullstack.springbootproject.model.user.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Activity extends AbstractAuditable<Employee, Long> {

    private String description; // JTBD
    private boolean ready; // State of activity
    private LocalDateTime schedulingDate; // When activity should be done
    private LocalDateTime readyDate; // When activity is done

    // Associations

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "VISIT_ID")
    @JsonIgnore
    private Visit visit;

    // Automatic functions

    @PreUpdate
    private void whenUpdate() {
        if (ready) {
            if (readyDate == null) readyDate = LocalDateTime.now();
        } else {
            readyDate = null;
        }
        setLastModifiedBy(getVisit().getEmployee());
        setLastModifiedDate(LocalDateTime.now());
    }

    @PrePersist
    private void whenCreate() {
        setReady(false);
        setCreatedBy(getVisit().getEmployee());
        setCreatedDate(LocalDateTime.now());
    }
}
