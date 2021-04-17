package pl.edu.wszib.student.fkaminsk.service;

import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

import java.util.Optional;

public interface UserService {
        ValidationResult register(User user);
        Iterable<User> getUsers();
        Optional<User> getUserById(int id);
        Boolean login(String login, String password);
}
