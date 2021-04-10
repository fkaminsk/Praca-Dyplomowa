package pl.edu.wszib.student.fkaminsk.service;

import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

import java.util.List;

public interface UserService {
        ValidationResult register(User user);
        List<User> getUsers();
        Boolean login(String login, String password);
}
