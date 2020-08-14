package pl.edu.wszib.student.fkaminsk.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pl.edu.wszib.student.fkaminsk.data.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails{

    private String login;
    private String password;
    List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

    public MyUserDetails(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.grantedAuthorityList.add(user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}