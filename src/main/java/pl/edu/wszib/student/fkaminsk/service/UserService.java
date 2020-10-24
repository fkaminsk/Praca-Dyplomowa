package pl.edu.wszib.student.fkaminsk.service;

import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

public interface UserService {
        ValidationResult register(User user);
}
