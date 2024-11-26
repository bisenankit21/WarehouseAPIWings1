package com.example.WarehouseAPIWings1.controller;

import com.example.WarehouseAPIWings1.model.Product;
import com.example.WarehouseAPIWings1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //To add the product details using product object
    @PostMapping("/product/add")
    public Object postProduct(@RequestBody Product product) {
        return productService.postProduct(product);
    }


    //TO get all the product details
    @GetMapping("/product/get")
    public Object getProduct() {
        return productService.getProduct();
    }

    //To update the product with the id as path variable and product as object in RequestBody
    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }


    //To delete the product with the id as path variable
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable int id) {
        return productService.deleteProductById(id);
    }

    //To get the product with the value using pathvariable.
    @GetMapping("/product/vendor")
    public ResponseEntity<Object> getSimilarVendor(@RequestParam String value) {
        return productService.getSimilarVendor(value);
    }
}
