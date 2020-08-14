package pl.edu.wszib.student.fkaminsk.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wszib.student.fkaminsk.enm.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Builder
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_users")
public class User {

    public User(int userId, String login, String password, String email, Role role, Collection<Order> orders) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.orders = orders;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String login;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonBackReference
    private Collection<Order> orders = new ArrayList();
}
