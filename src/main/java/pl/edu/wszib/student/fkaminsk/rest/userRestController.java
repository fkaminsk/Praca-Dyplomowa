package pl.edu.wszib.student.fkaminsk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.student.fkaminsk.data.UserRepository;
import pl.edu.wszib.student.fkaminsk.model.User;

import java.util.List;
import java.util.Optional;

@RestController
public class userRestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("log")
    public Optional<User> findByLogin2(){
        return userRepository.findByLogin("fifi1");
    }

    @GetMapping("/getAll")
    public Iterable<User> showall(){
        Iterable<User> result = userRepository.findAll();
        return result;
    }
}
