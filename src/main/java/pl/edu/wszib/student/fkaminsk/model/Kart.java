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
    private int kartId;
    @OneToOne(mappedBy = "", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private User user;
    @OneToMany
    @JoinColumn(name = "productId")
    private List<Product> inKart;

    public void addProduct(Product product){
        this.inKart.add(product);
    }
}
