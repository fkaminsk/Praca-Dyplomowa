package pl.edu.wszib.student.fkaminsk.controller;

import lombok.AllArgsConstructor;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.student.fkaminsk.enm.Category;
import pl.edu.wszib.student.fkaminsk.enm.Role;
import pl.edu.wszib.student.fkaminsk.model.Order;
import pl.edu.wszib.student.fkaminsk.model.Product;
import pl.edu.wszib.student.fkaminsk.model.Supplier;
import pl.edu.wszib.student.fkaminsk.model.User;

@AllArgsConstructor
@Controller
public class Test {

    @Autowired
    SessionFactory session;


    @GetMapping(value = "/useradd")
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

    @GetMapping(value = "/supplieradd")
    public String test2() {

        Session session = this.session.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            //User user = (User) session.createSQLQuery("select * from t_users where userId = 1").uniqueResult();


            session.save(Supplier.builder()
                    .companyName("kamykCorp")
                    .country("Poland")
                    .build()
            );


            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }

        System.out.println("supplier added");
        return "test";
    }

    @GetMapping(value = "/productadd")
    public String test3() {

        Session session = this.session.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Query query = session.createSQLQuery("select * from t_suppliers where supplierId = 1");

            Supplier supplier = (Supplier) session.get(Supplier.class,1);

            session.save(Product.builder()
                    .name("p1")
                    .supplier(supplier)
                    .categoryName(Category.AMPS)
                    .inStock(10)
                    .price(100)
                    .build()
            );

            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }

        System.out.println("product addded");
        return "test";
    }

}
