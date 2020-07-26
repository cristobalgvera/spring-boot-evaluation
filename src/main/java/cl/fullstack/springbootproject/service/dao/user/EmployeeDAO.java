package cl.fullstack.springbootproject.service.dao.user;

import cl.fullstack.springbootproject.model.user.Employee;
import cl.fullstack.springbootproject.service.dao.AbstractDAO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO extends AbstractDAO<Employee, Long> {
}
