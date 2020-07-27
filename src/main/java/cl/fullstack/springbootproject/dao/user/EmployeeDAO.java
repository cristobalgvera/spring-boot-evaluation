package cl.fullstack.springbootproject.dao.user;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.model.user.Employee;
import cl.fullstack.springbootproject.repository.CustomerRepo;
import cl.fullstack.springbootproject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class EmployeeDAO extends AbstractDAO<Employee, Long, EmployeeRepo> {
    @Autowired
    public EmployeeDAO(EmployeeRepo genericRepo) {
        super(genericRepo);
    }
}
