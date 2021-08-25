package pl.edu.wszib.student.fkaminsk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.student.fkaminsk.data.ProductRepository;
import pl.edu.wszib.student.fkaminsk.model.Product;
import pl.edu.wszib.student.fkaminsk.service.ProductService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


@Service
public class ProductServiceImpl implements ProductService {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductRepository repository;

    @Override
    public Iterable<Product> getProducts() {
        Iterable<Product> dbProducts = repository.findAll();
        List<Product> productList = StreamSupport.stream(dbProducts.spliterator(), false).collect(Collectors.toList());
        productList.forEach(product -> {
            if (product.getImage() != null) {
                product.setImage(decompressBytes(product.getImage()));
            }
        });
        return productList;
    }

    @Override
    public Optional<Product> getProductById(int id) {
        log.info("Fetching product with id: " + id);
        Optional<Product> dbProduct = repository.findById(id);
        if (dbProduct.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (dbProduct.get().getImage() != null) {
            byte[] decompressedImage = decompressBytes(dbProduct.get().getImage());
            dbProduct.get().setImage(decompressedImage);
        }
        return dbProduct;
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


    public void updateProductImage(MultipartFile image, int productId) {
        Optional<Product> dbProduct = repository.findById(productId);
        if (dbProduct.isEmpty()) {
            throw new NoSuchElementException();
        }
        Product updatedProduct = dbProduct.get();
        try {
            updatedProduct.setImage(compressBytes(image.getBytes()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        repository.save(updatedProduct);
    }

    @Override
    public void editProduct(Product editedProduct) {

    }

    @Override
    public void addExisitingProduct(int id) {

    }

    @Override
    public void removeProduct(int id) {

    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException ioe) {
            ioe.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
