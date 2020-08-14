package pl.edu.wszib.student.fkaminsk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

    @PostMapping("sucLogin")
    public String afterlogin(){
        return "login";
    }
}
