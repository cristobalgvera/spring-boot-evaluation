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
public class Summary extends AbstractAuditable<Employee, Long> {

    @Column(length = 2)
    private int rating; // 1 to 10 rating to measure results (just pedagogical statistics)
    private String description; // How visit was

    // Associations

    @OneToOne
    @JoinColumn(name = "VISIT_ID")
    @JsonIgnore
    private Visit visit;

    // Automatic functions

    @PreUpdate
    private void whenUpdate() {
        setLastModifiedBy(getVisit().getEmployee());
        setLastModifiedDate(LocalDateTime.now());
    }

    @PrePersist
    private void whenCreate() {
        setCreatedBy(getVisit().getEmployee());
        setCreatedDate(LocalDateTime.now());
    }
}
