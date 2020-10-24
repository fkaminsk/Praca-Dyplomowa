package pl.edu.wszib.student.fkaminsk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.service.UserService;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

@Controller
public class UserController {

    UserService userService;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @PostMapping("/register")
    public ResponseEntity<ValidationResult> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }
}
