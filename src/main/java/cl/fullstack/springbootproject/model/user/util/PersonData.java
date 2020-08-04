package cl.fullstack.springbootproject.model.user.util;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Embeddable
public class PersonData {
    @Column(length = 20)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(length = 15)
    private String phoneNumber;
    private LocalDateTime joinDate;

    // Automatic functions

    @PrePersist
    protected void autoSetJoinDate() {
        joinDate = LocalDateTime.now();
    }
}
