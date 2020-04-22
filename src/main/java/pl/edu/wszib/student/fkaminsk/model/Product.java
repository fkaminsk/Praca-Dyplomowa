package pl.edu.wszib.student.fkaminsk.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Product {

    public Product(String name, int supplierId, int categoryId, float price) {
        this.name = name;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @ManyToOne
    @JoinColumn(name = "kartId")
    private Kart kart;

    private String name;
    private int supplierId;
    private int categoryId;
    private float price;

}
