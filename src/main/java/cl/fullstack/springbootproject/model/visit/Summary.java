package cl.fullstack.springbootproject.model.visit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Summary {
    @Id
    private Long visitId; // Always this fields will have his visit id

    @Column(length = 2)
    private int rating; // 1 to 10 rating to measure results (just pedagogical statistics)
    private String description; // How visit was
    private Date lastUpdate; // TODO: Auto set date

    // Associations

    @MapsId
    @OneToOne
    @JoinColumn(name = "VISIT_ID")
    @JsonIgnore
    private Visit visit;
}
