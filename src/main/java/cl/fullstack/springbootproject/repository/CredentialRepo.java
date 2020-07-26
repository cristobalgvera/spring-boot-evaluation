package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.user.util.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepo extends JpaRepository<Credential, Long> {
}
