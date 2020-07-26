package cl.fullstack.springbootproject.model.user;

import cl.fullstack.springbootproject.model.user.util.Credential;
import cl.fullstack.springbootproject.model.user.util.PersonData;
import cl.fullstack.springbootproject.model.visit.Visit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee extends AbstractPersistable<Long> {
    @Embedded
    private PersonData employeeData;

    // Associations

    @OneToOne(mappedBy = "employee",
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Credential credential;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Visit> visits;

    public void addVisit(Visit visit) {
        if (visits == null) visits = new ArrayList<>();
        visits.add(visit);
        visit.setEmployee(this);
    }
}
