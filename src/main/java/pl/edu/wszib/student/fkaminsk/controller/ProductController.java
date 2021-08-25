package pl.edu.wszib.student.fkaminsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.student.fkaminsk.model.Product;
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

    @PostMapping("/addProduct")
    public void addNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @PostMapping("/{id}/product/update")
    public void updateProduct(@RequestParam("image") MultipartFile image, @PathVariable int id) {
        productService.updateProductImage(image,id);
    }
}
