package cl.fullstack.springbootproject.dao.visit;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.dao.user.CustomerDAO;
import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.model.visit.Address;
import cl.fullstack.springbootproject.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Transactional
@Component
public class AddressDAO extends AbstractDAO<Address, Long, AddressRepo> {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    public AddressDAO(AddressRepo genericRepo) {
        super(genericRepo);
    }

    public Address saveWithCustomerId(Address address, Long customerId) {
        Customer customer = customerDAO.getOne(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Not found: " + customerId));
        address.setCustomer(customer);
        customer.addAddress(address);
        return save(address);
    }

    public Collection<Address> getAllByCustomerId(Long customerId) {
        return addressRepo.getAllByCustomer_Id(customerId).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }
}
