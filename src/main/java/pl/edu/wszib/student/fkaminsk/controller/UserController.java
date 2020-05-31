package pl.edu.wszib.student.fkaminsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.student.fkaminsk.data.UserRepository;
import pl.edu.wszib.student.fkaminsk.model.User;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("addUser")
    public String displayUsers(){

        userRepository.save(User.builder()
                .login("fifi2")
                .password("1234")
                .email("fmkaminski2@gmail.com")
                .build());

        for (User user:userRepository.findAll()) {
            System.out.println(user);
        }

        return "redirect:";
    }



}
