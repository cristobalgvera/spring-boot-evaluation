package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.user.EmployeeDAO;
import cl.fullstack.springbootproject.model.user.Employee;
import cl.fullstack.springbootproject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends GenericService<Employee, Long, EmployeeRepo, EmployeeDAO> {
    @Autowired
    EmployeeService(EmployeeDAO employeeDAO) {
        super(employeeDAO);
    }

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee findEmployeeByEmail(String email) {
        return employeeRepo.findByCredential_Email(email)
                .orElse(null);
    }
}
