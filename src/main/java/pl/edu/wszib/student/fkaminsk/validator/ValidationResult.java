package pl.edu.wszib.student.fkaminsk.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.wszib.student.fkaminsk.model.User;

@Setter
@Getter
@AllArgsConstructor
public class ValidationResult {
    User user;
    private boolean login;
    private boolean email;
}
