package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.user.util.CredentialDAO;
import cl.fullstack.springbootproject.model.user.util.Credential;
import cl.fullstack.springbootproject.repository.CredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CredentialService extends GenericService<Credential, Long, CredentialRepo, CredentialDAO> {

    @Autowired
    CredentialService(CredentialDAO credentialDAO) {
        super(credentialDAO);
    }

    @Autowired
    private CredentialRepo credentialRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Credential save(Credential credential) {
        credential.setPassword(bCryptPasswordEncoder.encode(credential.getPassword()));
        return super.save(credential);
    }

    @Override
    public void update(Credential credential) {
        credential.setPassword(bCryptPasswordEncoder.encode(credential.getPassword()));
        super.update(credential);
    }

    public Credential findByCustomerId(Long customerId) {
        return credentialRepo.findByCustomer_Id(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Not found customer: " + customerId));
    }

    public Credential findByEmployeeId(Long employeeId) {
        return credentialRepo.findByEmployee_Id(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Not found employee: " + employeeId));
    }

    public Credential findByEmail(String email) {
        return credentialRepo.findByEmail(email)
                .orElse(null);
    }
}
