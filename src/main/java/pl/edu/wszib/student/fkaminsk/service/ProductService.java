package pl.edu.wszib.student.fkaminsk.service;

import pl.edu.wszib.student.fkaminsk.model.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> getProducts();
    Optional<Product> getProductById(int id);
    void addNewProduct(Product product);
    void addExisitingProduct(int id);
    void removeProduct(int id);
}
