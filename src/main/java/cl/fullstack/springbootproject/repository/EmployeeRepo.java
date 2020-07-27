package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.user.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends GenericRepo<Employee, Long> {
}
