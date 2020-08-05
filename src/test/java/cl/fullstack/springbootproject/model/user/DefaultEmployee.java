package cl.fullstack.springbootproject.model.user;

import cl.fullstack.springbootproject.model.DefaultModel;

public class DefaultEmployee extends AbstractUser implements DefaultModel<Employee> {
    @Override
    public Employee create() {
        setDefaultStuffs("ROLE_EMPLOYEE");

        Employee employee = new Employee();
        {
            employee.setCredential(credential);
            employee.setPersonData(personData);
            credential.setEmployee(employee);
        }
        return employee;
    }
}
