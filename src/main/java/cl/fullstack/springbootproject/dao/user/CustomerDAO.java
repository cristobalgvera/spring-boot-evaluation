package cl.fullstack.springbootproject.dao.user;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class CustomerDAO extends AbstractDAO<Customer, Long, CustomerRepo> {
    @Autowired
    public CustomerDAO(CustomerRepo genericRepo) {
        super(genericRepo);
    }
}
