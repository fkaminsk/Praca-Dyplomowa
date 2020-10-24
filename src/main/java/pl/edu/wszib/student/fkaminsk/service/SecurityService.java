package pl.edu.wszib.student.fkaminsk.service;

public interface SecurityService {

    String findLoggedInUser();

    void autoLogin(String username, String password);
}
