package pl.edu.wszib.student.fkaminsk.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name="t_supplier")
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    private String companyName;
    private String country;


}
