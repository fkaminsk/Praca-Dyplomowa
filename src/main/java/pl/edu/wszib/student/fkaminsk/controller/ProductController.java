package pl.edu.wszib.student.fkaminsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.student.fkaminsk.model.Product;
import pl.edu.wszib.student.fkaminsk.model.Supplier;
import pl.edu.wszib.student.fkaminsk.service.ProductService;

import java.util.Optional;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}/product")
    public Optional<Product> getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "/product", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void addNewProduct(@RequestPart("product") Product product, @RequestPart("image") MultipartFile image) {
        productService.addNewProduct(product, image);
    }

    @DeleteMapping("/{id}/product")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @PatchMapping("/{id}/product")
    public void updateProduct(@RequestParam("image") MultipartFile image, @PathVariable int id) {
        productService.updateProductImage(image, id);
    }

    @GetMapping("/suppliers")
    public Iterable<Supplier> getSuppliers() {
        return productService.getSuppliers();
    }
}
