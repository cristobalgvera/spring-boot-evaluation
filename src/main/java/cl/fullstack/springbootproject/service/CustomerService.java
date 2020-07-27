package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.user.CustomerDAO;
import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends GenericService<Customer, Long, CustomerRepo, CustomerDAO> {

    @Autowired
    CustomerService(CustomerDAO customerDAO) {
        super(customerDAO);
    }
}
