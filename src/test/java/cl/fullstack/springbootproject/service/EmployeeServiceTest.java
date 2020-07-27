package cl.fullstack.springbootproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest extends AbstractTest {
    @Test
    @Transactional
    protected void createEmployee() {
        log.setCurrentTest("INSERT EMPLOYEE TO DATABASE");
        log.start();
        createDefaultModel();

        dbEmployee = employeeService.save(testEmployee);

        log.message(dbEmployee);
        isNumeric(dbEmployee.getId());
        log.finish();
    }

}