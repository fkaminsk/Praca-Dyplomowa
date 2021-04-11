package pl.edu.wszib.student.fkaminsk.model.Authentication;

import lombok.Data;

import java.util.Date;

@Data
public class AuthenticationResponse {
    private final String jwt;
    private final Date expiresAt;
}
