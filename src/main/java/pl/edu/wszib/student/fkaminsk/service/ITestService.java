package pl.edu.wszib.student.fkaminsk.service;

import pl.edu.wszib.student.fkaminsk.enm.Role;

public interface ITestService {
    void insertNewUser(String login, String password, String email, Role role);
    void deleteUser(int userId);

}
