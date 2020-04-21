package pl.edu.wszib.student.fkaminsk.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="t_karts")
public class Kart {

    public Kart(){
        this.inKart = new ArrayList<>();
    }

    @Id
    @GeneratedValue
    @Column(name="kart_id")
    private int kartId;
    @ElementCollection(targetClass = Product.class)
    private List<Product> inKart;

    public void addProduct(Product product){
        this.inKart.add(product);
    }
}
