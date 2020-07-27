package cl.fullstack.springbootproject.dao.user.util;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.model.user.util.Credential;
import cl.fullstack.springbootproject.repository.CredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class CredentialDAO extends AbstractDAO<Credential, Long, CredentialRepo> {

    @Autowired
    public CredentialDAO(CredentialRepo genericRepo) {
        super(genericRepo);
    }
}
