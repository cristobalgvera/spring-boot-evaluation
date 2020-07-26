package cl.fullstack.springbootproject.service.dao.user;

import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.repository.CustomerRepo;
import cl.fullstack.springbootproject.service.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDAO implements DAO<Customer, Long> {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Optional<Customer> getOne(Long id) {
        return Optional.ofNullable(customerRepo.getOne(id));
    }

    @Override
    public Collection<Customer> getAll() {
        return customerRepo.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {
        Customer dbCustomer = getOne(customer.getId())
                .orElseThrow(() -> new EntityNotFoundException("Not found customer: " + customer.getId()));

        if (!customer.getCustomerData().getName().equals(dbCustomer.getCustomerData().getName()))
            dbCustomer.getCustomerData().setName(customer.getCustomerData().getName());

        if (!customer.getCustomerData().getLastName().equals(dbCustomer.getCustomerData().getLastName()))
            dbCustomer.getCustomerData().setLastName(customer.getCustomerData().getLastName());

        if (!customer.getCustomerData().getPhoneNumber().equals(dbCustomer.getCustomerData().getPhoneNumber()))
            dbCustomer.getCustomerData().setPhoneNumber(customer.getCustomerData().getPhoneNumber());

        customerRepo.save(dbCustomer);
    }

    @Override
    public void delete(Long id) {
        customerRepo.deleteById(id);
    }
}
