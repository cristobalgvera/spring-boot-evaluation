package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.user.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends GenericRepo<Employee, Long> {
    Optional<Employee> findByCredential_Email(String email);
}
