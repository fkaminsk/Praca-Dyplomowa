package pl.edu.wszib.student.fkaminsk.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.student.fkaminsk.model.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier,Integer> {
}
