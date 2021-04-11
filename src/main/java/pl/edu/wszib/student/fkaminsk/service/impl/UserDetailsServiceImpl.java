package pl.edu.wszib.student.fkaminsk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.student.fkaminsk.data.UserRepository;
import pl.edu.wszib.student.fkaminsk.model.MyUserDetails;
import pl.edu.wszib.student.fkaminsk.model.User;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(login);

        if(user.isEmpty()) throw new UsernameNotFoundException(login);

        return new MyUserDetails(user.get());
    }
}
