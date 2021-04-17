package pl.edu.wszib.student.fkaminsk.controller;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.student.fkaminsk.model.Authentication.AuthenticationRequest;
import pl.edu.wszib.student.fkaminsk.model.Authentication.AuthenticationResponse;
import pl.edu.wszib.student.fkaminsk.model.User;
import pl.edu.wszib.student.fkaminsk.service.UserService;
import pl.edu.wszib.student.fkaminsk.service.impl.UserDetailsServiceImpl;
import pl.edu.wszib.student.fkaminsk.util.JwtUtil;
import pl.edu.wszib.student.fkaminsk.validator.ValidationResult;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/{id}/user")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<ValidationResult> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getLogin());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        final Date expiresAt = jwtTokenUtil.extractExpiration(jwt);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, expiresAt));
    }
}
