package cl.fullstack.springbootproject.model.visit;

import cl.fullstack.springbootproject.model.user.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {
    @Id
    @GeneratedValue(generator = "ADDRESS_SEQ")
    private Long id;

    @Column(length = 25, nullable = false)
    private String country;

    @Column(length = 40, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String street;

    @Column(length = 3)
    private String block; // If is necessary

    @Column(nullable = false)
    private int addressNumber;

    // Associations

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonIgnore
    private Customer customer;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    @JsonIgnore
    private Visit visit;
}
