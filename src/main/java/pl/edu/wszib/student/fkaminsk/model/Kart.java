package pl.edu.wszib.student.fkaminsk.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "t_karts")
public class Kart {

    public Kart() {
        this.products = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kartId;
    @OneToOne(mappedBy = "kart")
    @JoinColumn(name = "userId")
    private User user;
    @OneToMany(mappedBy = "kart")
    private Set<Product> products;


    public void addProduct(Product product) {
        this.products.add(product);
    }
}
