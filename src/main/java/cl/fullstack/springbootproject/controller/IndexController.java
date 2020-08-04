package cl.fullstack.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    @RequestMapping(value ="/login")
    public String method(){
        return "security/login";
    }
}