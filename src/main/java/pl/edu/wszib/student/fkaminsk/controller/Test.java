package pl.edu.wszib.student.fkaminsk.controller;

import lombok.AllArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.student.fkaminsk.enm.Role;
import pl.edu.wszib.student.fkaminsk.model.User;

@AllArgsConstructor
@Controller
public class Test {

    @Autowired
    SessionFactory session;


    @GetMapping(value = "/user")
    public String test() {




        Session session = this.session.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(User.builder()
                    .login("fkaminsk")
                    .password("fifi")
                    .email("fkaminsk@sm.pl")
                    .role(Role.ADMIN)
                    .build());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }

        System.out.println("addeduser");
        return "test";
    }

    @GetMapping(value = "/order")
    public String test2() {
        Session session = this.session.openSession();




        Transaction tx = null;

        try {

            tx = session.beginTransaction();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }

        System.out.println("addedkart");
        return "test";
    }

}
