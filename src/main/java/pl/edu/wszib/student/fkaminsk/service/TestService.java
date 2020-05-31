package pl.edu.wszib.student.fkaminsk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.wszib.student.fkaminsk.data.OrderRepository;
import pl.edu.wszib.student.fkaminsk.data.ProductRepository;
import pl.edu.wszib.student.fkaminsk.data.UserRepository;
import pl.edu.wszib.student.fkaminsk.model.Order;
import pl.edu.wszib.student.fkaminsk.model.Product;
import pl.edu.wszib.student.fkaminsk.model.User;

import java.util.Optional;

@Controller
@ResponseBody
public class TestService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("addorder")
    public void addProductToOrder(@RequestParam Integer orderId,
                                  @RequestParam Integer productId
    ) {
        System.out.println(orderId + " " + productId);

        //w db masz zdefiniowany jakis order wiec go znajdujesz iz zapisujesz do kolekcji
        Optional<Order> reslist1 = orderRepository.findById(orderId);
        //w db masz zdefiniowany produkt, to samo
        Optional<Product> reslist2 = productRepository.findById(productId);
        //tu wrzucasz sobie z kolekcji do zmiennej odpowiednich typow tych obiektow
        Product product = reslist2.get();
        Order order = reslist1.get();

        if (reslist1.isPresent() && reslist2.isPresent()) {
            System.out.println("record present");
            order.addProduct(product); //dodajesz product do orderu
            System.out.println("product added to order");
            orderRepository.save(order); //i zapisujesz order, w db powinienes miec tabele lacznikowa jak dobrze
            //mapujesz relacje i w niej powinny sie pojawic idki tych rekordkow ktore chciales powiazac co znaczy ze jest
            //git
            System.out.println("updated order saved");
        } else {
            System.out.println("need both list to be populated");
        }
    }

    @GetMapping
    public void getAllUsers() {
        Iterable<User> result = userRepository.findAll();
        for (User user : result) {
            System.out.println(user.getLogin() + " " + user.getRole());
        }
    }
}
