package pl.edu.wszib.student.fkaminsk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wszib.student.fkaminsk.enm.Role;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name="t_users")
public class User {

    public User(String login, String password, String email, Role role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.kart = new Kart();
    }

    @Id
    @GeneratedValue
    private int userId;
    private String login;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kartId")
    public Kart kart;



}
