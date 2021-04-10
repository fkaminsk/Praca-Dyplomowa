package pl.edu.wszib.student.fkaminsk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.service.UserService;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

import java.util.List;

@Controller
public class UserController {

    UserService userService;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @PostMapping("/login")
    public Boolean login(String login, String password) {
        return userService.login(login,password);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<ValidationResult> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }
}
