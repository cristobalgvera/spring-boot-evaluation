package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
