package cl.fullstack.springbootproject.controller;

import cl.fullstack.springbootproject.constant.Role;
import cl.fullstack.springbootproject.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SecurityController {
    @Autowired
    private CredentialService credentialService;

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "security/login";
    }

    @GetMapping("/home")
    public String home(Principal principal) {
        String role = credentialService.findByEmail(principal.getName()).getRoles();
        switch (role) {
            case Role.CUSTOMER:
                return "redirect:/";
            case Role.EMPLOYEE:
                return "redirect:/employee/home";
            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }
    }
}
