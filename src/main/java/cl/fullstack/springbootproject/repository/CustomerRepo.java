package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.user.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends GenericRepo<Customer, Long> {
}
