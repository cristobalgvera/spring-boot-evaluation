package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Address;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AddressRepo extends GenericRepo<Address, Long> {
    Collection<Address> getAllByCustomer_Id(Long customerId);
}
