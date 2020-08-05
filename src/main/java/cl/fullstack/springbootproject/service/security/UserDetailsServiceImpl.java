package cl.fullstack.springbootproject.service.security;

import cl.fullstack.springbootproject.model.user.util.Credential;
import cl.fullstack.springbootproject.repository.CredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredentialRepo credentialRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Credential> credential = credentialRepo.findByEmail(email);
        credential.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
        return credential.map(UserDetailsPOJO::new).get();
    }
}
