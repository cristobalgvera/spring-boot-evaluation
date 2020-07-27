package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.user.util.CredentialDAO;
import cl.fullstack.springbootproject.model.user.util.Credential;
import cl.fullstack.springbootproject.repository.CredentialRepo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CredentialService extends GenericService<Credential, Long, CredentialRepo, CredentialDAO> {
    @Autowired
    private CredentialRepo credentialRepo;

    @Autowired
    CredentialService(CredentialDAO credentialDAO) {
        super(credentialDAO);
    }

    public Credential getByCustomerId(Long customerId) {
        return credentialRepo.findByCustomer_Id(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Not found customer: " + customerId));
    }

    public Credential getByEmployeeId(Long employeeId) {
        return credentialRepo.findByEmployee_Id(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Not found employee: " + employeeId));
    }
}
