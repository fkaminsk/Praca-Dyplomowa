package pl.edu.wszib.student.fkaminsk.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.student.fkaminsk.enm.Role;
import pl.edu.wszib.student.fkaminsk.model.Kart;
import pl.edu.wszib.student.fkaminsk.model.Product;
import pl.edu.wszib.student.fkaminsk.model.User;

@Controller
public class Test {

    @Autowired
    SessionFactory session;


    @GetMapping(value = "/user")
    public String test() {
        Session session = this.session.openSession();

        User user = new User("filip", "filip", "kamyk@email.co", Role.ADMIN);
        //Product product4 = new Product("p4", 1, 1, 1);

        Product product2 = new Product("p2", 1, 1, 1);
        Product product3 = new Product("p1", 1, 1, 1);

        user.kart.addProduct(product2);
        user.kart.addProduct(product3);
        Transaction tx = null;

        try {

            tx = session.beginTransaction();

            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }

        System.out.println("addeduser");
        return "test";
    }

    @GetMapping(value = "/kart")
    public String test2() {
        Session session = this.session.openSession();

        Kart kart = new Kart();


        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.save(kart);
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
