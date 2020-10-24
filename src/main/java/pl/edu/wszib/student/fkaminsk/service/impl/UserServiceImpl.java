package pl.edu.wszib.student.fkaminsk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.fkaminsk.data.UserRepository;
import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.service.UserService;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private ValidationResult validate(User user) {
        return new ValidationResult(user, validateLogin(user), validateEmail(user));
    }

    private boolean validateLogin(User user) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .noneMatch(u -> u.getLogin().equals(user.getLogin()));
    }

    private boolean validateEmail(User user) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .noneMatch(u -> u.getEmail().equals(user.getEmail()));
    }

    @Override
    public ValidationResult register(User user) {
        ValidationResult result = validate(user);
        if (result.isLogin() && result.isEmail()) {
            userRepository.save(user);
            logger.debug(String.format("User %s registered", user.getLogin()));
            return result;
        } else {
            logger.debug(String.format("User %s not registered due to existing credentials", user.getLogin()));
            return result;
        }
    }


}
