package pl.edu.wszib.student.fkaminsk.model.Authentication;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String login;
    private String password;
}
