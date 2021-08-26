package pl.edu.wszib.student.fkaminsk.service;

import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.student.fkaminsk.model.Product;
import pl.edu.wszib.student.fkaminsk.model.Supplier;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> getProducts();
    Optional<Product> getProductById(int id);
    void addNewProduct(Product product, MultipartFile image);
    void deleteProductById(int id);
    void updateProductImage(MultipartFile image, int productId);
    void editProduct(Product editedProduct);
    void addExisitingProduct(int id);
    void removeProduct(int id);
    Iterable<Supplier> getSuppliers();
}
