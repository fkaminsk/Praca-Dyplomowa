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
@Table(name="t_suppliers")
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private Collection<Product> products = new ArrayList<>();
    private String companyName;
    private String country;


}
