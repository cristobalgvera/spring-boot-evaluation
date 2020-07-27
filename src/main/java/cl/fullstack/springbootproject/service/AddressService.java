package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.visit.AddressDAO;
import cl.fullstack.springbootproject.model.visit.Address;
import cl.fullstack.springbootproject.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends GenericService<Address, Long, AddressRepo, AddressDAO> {

    @Autowired
    AddressService(AddressDAO addressDAO) {
        super(addressDAO);
    }
}
