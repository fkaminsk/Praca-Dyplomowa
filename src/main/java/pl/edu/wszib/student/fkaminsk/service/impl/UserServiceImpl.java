package pl.edu.wszib.student.fkaminsk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.fkaminsk.data.UserRepository;
import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.service.UserService;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

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
    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
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

    @Override
    public Boolean login(String login, String password) {
        UsernamePasswordAuthenticationToken authenticationTokenRequest = new
                UsernamePasswordAuthenticationToken(login, password);
        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationTokenRequest);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            logger.info("authenticated successf" + login);
        } catch (BadCredentialsException ex) {
            logger.error("bad credentials!");
            return false;
        }
        return true;
    }

}
