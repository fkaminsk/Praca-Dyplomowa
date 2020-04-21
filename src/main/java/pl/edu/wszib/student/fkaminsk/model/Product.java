package pl.edu.wszib.student.fkaminsk.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    @GeneratedValue
    private int productId;
    private String name;
    private int supplierId;
    private  int categoryId;
    private float price;

}
