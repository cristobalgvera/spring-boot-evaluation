package cl.fullstack.springbootproject.model.user.util;

import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.model.user.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"employee", "customer"})
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Credential extends AbstractPersistable<Long> {

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    @Column(length = 120, nullable = false)
    private String password;

    @Column(length = 30)
    private String roles;
    private boolean active;

    // Associations

    @OneToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    @JsonIgnore
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonIgnore
    private Customer customer;

    // Automatic functions

    @PrePersist
    private void defineRole() {
        if (employee != null && customer == null) {
            roles = "ROLE_EMPLOYEE";
        } else if (employee == null && customer != null) {
            roles = "ROLE_CUSTOMER";
        } else {
            roles = "ROLE_ADMIN";
        }
    }

    @Override
    public String toString() {
        Long userId;
        if (customer != null) userId = customer.getId();
        else userId = employee.getId();

        return "Credential{" +
                super.toString() +
                ", user_id='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", active=" + active +
                '}';
    }
}
