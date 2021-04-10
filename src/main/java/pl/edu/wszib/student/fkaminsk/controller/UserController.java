package pl.edu.wszib.student.fkaminsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.service.UserService;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home() {
        return "login";
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
