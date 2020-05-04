package pl.edu.wszib.student.fkaminsk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="t_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;
    private String date;
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "order")
    private Collection<OrderDetails> orderDetails = new ArrayList<>();
}
