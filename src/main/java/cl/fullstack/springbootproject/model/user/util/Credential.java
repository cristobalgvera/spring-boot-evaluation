package cl.fullstack.springbootproject.model.user.util;

import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.model.user.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Credential {
    @Id
    @GeneratedValue(generator = "CREDENTIAL_SEQ")
    private Long id;

    @Column(length = 40, nullable = false, unique = true)
    private String email;

    @Column(length = 120, nullable = false)
    private String password; // TODO: Encrypt password

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
}
