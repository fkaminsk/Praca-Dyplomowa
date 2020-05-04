package pl.edu.wszib.student.fkaminsk.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wszib.student.fkaminsk.enm.Category;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name="t_products")
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category categoryName;
    private int supplierId;
    private int inStock;
    private float price;



}
