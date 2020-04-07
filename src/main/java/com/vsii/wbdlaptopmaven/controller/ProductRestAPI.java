package com.vsii.wbdlaptopmaven.controller;

import com.vsii.wbdlaptopmaven.model.Product;
import com.vsii.wbdlaptopmaven.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ProductRestAPI {

    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> getListProduct() {
        List<Product> products = (List<Product>) productService.findAll();
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);

        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {

        product.setUpdate(false);
        productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product, @PathVariable Long id) {
        Optional<Product> product1 = productService.findById(id);

        if (!product1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        product1.get().setName(product.getName());
        product1.get().setCpu(product.getCpu());
        product1.get().setRam(product.getRam());
        product1.get().setPrice(product.getPrice());
        product1.get().setDescription(product.getDescription());
        product1.get().setUpdate(true);

        productService.save(product1.get());

        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);

        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        productService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
