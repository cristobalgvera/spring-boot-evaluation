package cl.fullstack.springbootproject.controller;

import cl.fullstack.springbootproject.model.user.Employee;
import cl.fullstack.springbootproject.model.visit.Summary;
import cl.fullstack.springbootproject.model.visit.Visit;
import cl.fullstack.springbootproject.service.EmployeeService;
import cl.fullstack.springbootproject.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/home")
    public String home(Principal principal, Model model) {
        Employee employee = employeeService.findEmployeeByEmail(principal.getName());
        httpSession.setAttribute("user", employee);
        model.addAttribute("allVisits", employee.getVisits());
        model.addAttribute("payments", employeeService.findAllPaymentsByEmployee(employee));
        return "employee/home";
    }

    @GetMapping("/visit/{id}")
    public String details(@PathVariable("id") Long visitId, Model model) {
        Map<String, Object> attributes = visitService.getMappedVisitDetails(visitId);
        model.addAllAttributes(attributes);
        return "employee/visit-details";
    }

    @GetMapping("/visit/finish/{visitId}")
    public String summary(@PathVariable("visitId") Long visitId, Model model,
                          HttpServletRequest request) {
        if (request.getParameter("submit-btn").equals("go-back"))
            return "redirect:/employee/home";

        model.addAttribute("summary", visitService.getOne(visitId).getSummary());
        return "employee/finish";
    }

    @Transactional
    @PostMapping("/visit/finish/{visitId}")
    public String finish(@PathVariable("visitId") Long visitId, @ModelAttribute("summary") Summary summary,
                         HttpServletRequest request) {
        Visit visit = visitService.getOne(visitId);
        visit.getSummary().setDescription(summary.getDescription());
        visit.getSummary().setRating(summary.getRating());

        if (request.getParameter("submit-btn").equals("terminate")) visit.setReady(true);

        visitService.update(visit);
        return "redirect:/employee/home";
    }
}
