package pl.edu.wszib.student.fkaminsk.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wszib.student.fkaminsk.enm.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "t_products")
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private String shortDescription;
    private String description;
    private byte[] image;
    @Enumerated(EnumType.STRING)
    @JsonDeserialize
    private Category categoryName;
    @JsonBackReference
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
    private Supplier supplier;
    private int inStock;
    private float price;
    @JsonIgnore
    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList = new ArrayList<>();

    public void addToOrder(Order order) {
        this.orderList.add(order);
    }


}
