package cl.fullstack.springbootproject.model.user;

import cl.fullstack.springbootproject.model.user.util.Credential;
import cl.fullstack.springbootproject.model.user.util.PersonData;

import java.time.LocalDateTime;

public abstract class AbstractUser {
    protected String role;
    protected Credential credential;
    protected PersonData personData;

    protected void setDefaultStuffs(String role) {
        setRole(role);
        setDefaultCredential();
        setDefaultPersonData();
    }

    private void setDefaultPersonData() {
        personData = new PersonData();
        {
            personData.setName(role + "Name");
            personData.setLastName(role + "LastName");
            personData.setJoinDate(LocalDateTime.now());
            personData.setPhoneNumber("+01298765432");
        }
    }

    private void setDefaultCredential() {
        credential = new Credential();
        {
            credential.setEmail(role + "@foo.cl");
            credential.setPassword("foopass");
            credential.setRoles(role);
            credential.setActive(true);
        }
    }

    private void setRole(String role) {
        this.role = role;
    }
}
