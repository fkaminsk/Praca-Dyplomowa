package pl.edu.wszib.student.fkaminsk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="t_order_details")
@Entity
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId")
    private Order order;
    @OneToOne
    @JoinColumn(name="productId")
    private Product product;
    private int amount;

}
