package cl.fullstack.springbootproject.controller;

import cl.fullstack.springbootproject.model.user.Employee;
import cl.fullstack.springbootproject.service.EmployeeService;
import cl.fullstack.springbootproject.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VisitService visitService;

    @GetMapping
    String home(Principal principal, Model model) {
        Employee employee = employeeService.findEmployeeByEmail(principal.getName());
        model.addAttribute("allVisits", visitService.findAllVisitsByEmployeeId(employee.getId()));
        return "employee/home";
    }
}
