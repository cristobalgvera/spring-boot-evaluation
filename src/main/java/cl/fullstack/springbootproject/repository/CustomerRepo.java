package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.user.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends GenericRepo<Customer, Long> {
    Optional<Customer> findByCredential_Email(String email);
}
