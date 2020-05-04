package pl.edu.wszib.student.fkaminsk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wszib.student.fkaminsk.enm.Category;

import javax.persistence.*;

@Builder
@AllArgsConstructor
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
    @ManyToOne
    @JoinColumn(name="supplierId", nullable = false)
    private Supplier supplier;
    private int inStock;
    private float price;



}
