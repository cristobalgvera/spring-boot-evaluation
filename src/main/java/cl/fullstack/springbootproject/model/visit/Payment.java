package cl.fullstack.springbootproject.model.visit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment {
    @Id
    private Long visitId; // Always this fields will have his visit id

    private Date payDay; // When pay must be done
    private Long amount;
    private boolean ready; // State of payment

    // Associations

    @MapsId
    @OneToOne
    @JoinColumn(name = "VISIT_ID")
    @JsonIgnore
    private Visit visit;

}
