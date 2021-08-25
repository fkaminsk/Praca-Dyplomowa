package pl.edu.wszib.student.fkaminsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.student.fkaminsk.model.Product;
import pl.edu.wszib.student.fkaminsk.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/addNewProduct")
    public void addNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }
}
