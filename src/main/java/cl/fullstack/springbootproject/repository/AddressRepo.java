package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
