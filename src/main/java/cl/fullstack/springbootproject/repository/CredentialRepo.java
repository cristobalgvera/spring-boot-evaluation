package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.user.util.Credential;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepo extends GenericRepo<Credential, Long> {
    Optional<Credential> findByCustomer_Id(Long id);
    Optional<Credential> findByEmployee_Id(Long id);
    Optional<Credential> findByEmail(String email);
}
