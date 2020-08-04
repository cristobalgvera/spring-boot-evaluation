package cl.fullstack.springbootproject.controller;

import cl.fullstack.springbootproject.model.user.Employee;
import cl.fullstack.springbootproject.model.visit.Visit;
import cl.fullstack.springbootproject.service.EmployeeService;
import cl.fullstack.springbootproject.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping
    String home(Principal principal, Model model) {
        Employee employee = employeeService.findEmployeeByEmail(principal.getName());
        httpSession.setAttribute("user", employee);
        model.addAttribute("allVisits", employee.getVisits());
        model.addAttribute("payments", employeeService.findAllPaymentsByEmployee(employee));
        return "employee/home";
    }
}
