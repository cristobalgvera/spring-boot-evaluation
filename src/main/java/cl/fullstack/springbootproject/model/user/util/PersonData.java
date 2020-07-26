package cl.fullstack.springbootproject.model.user.util;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Embeddable
public class PersonData {
    @Column(length = 20)
    private String name;

    @Column(length = 30)
    private String lastName;

    @Column(length = 15)
    private String phoneNumber;
    private Date joinDate;

    // Automatic functions

    @PrePersist
    protected void autoSetJoinDate() {
        joinDate = new Date();
    }
}
