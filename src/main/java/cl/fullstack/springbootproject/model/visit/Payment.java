package cl.fullstack.springbootproject.model.visit;

import cl.fullstack.springbootproject.model.user.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment extends AbstractAuditable<Customer, Long> {

    private LocalDateTime payDay; // When pay must be done
    private Long amount;
    private boolean ready; // State of payment

    // Associations

    @OneToOne
    @JoinColumn(name = "VISIT_ID")
    @JsonIgnore
    private Visit visit;

    // Automatic functions

    @PreUpdate
    private void whenUpdate() {
        setLastModifiedBy(getVisit().getCustomer());
        setLastModifiedDate(LocalDateTime.now());
    }

    @PrePersist
    private void whenCreate() {
        setReady(false);
        setCreatedBy(getVisit().getCustomer());
        setCreatedDate(LocalDateTime.now());
    }
}
