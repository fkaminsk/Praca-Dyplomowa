package pl.edu.wszib.student.fkaminsk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.fkaminsk.data.ProductRepository;
import pl.edu.wszib.student.fkaminsk.model.Product;
import pl.edu.wszib.student.fkaminsk.service.ProductService;

import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductRepository repository;

    @Override
    public Iterable<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        log.info("Fetching product with id: " + id);
        return repository.findById(id);
    }

    @Override
    public void addNewProduct(Product product) {
        try {
            log.info("Adding new product: " + product.getName());
            repository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addExisitingProduct(int id) {

    }

    @Override
    public void removeProduct(int id) {

    }
}
