package com.example.WarehouseAPIWings1.service;

import com.example.WarehouseAPIWings1.model.Product;
import com.example.WarehouseAPIWings1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

   //to post all the product details
    // created 201
    //bad request 400
    public Object postProduct(Product product) {
        if(productRepository.existsBySku(product.getSku())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try{
            productRepository.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    //to get all the product details
    // ok 200
    //bad request 400

    public Object getProduct() {
        List<Product> productList = productRepository.findAll();
        if(productList.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
        return ResponseEntity.status(HttpStatus.OK).body(productList);
        }
    }

    //to get the product with the value(path variable)
    // ok 200
    //bad request 400

    public ResponseEntity<Object> getSimilarVendor(String value) {
        List<Product> productList = productRepository.findByVendor(value);
        if(productList.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(productList);
        }
    }

    //to update the product with the id as path variable and product as object in RequestBody
    // ok 200
    //bad request 400
    public ResponseEntity<Object> updateProduct(int id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Product exitingProduct  = optionalProduct.get();
        if(exitingProduct.getId()!=id){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            try{
                exitingProduct.setName(product.getName());
                exitingProduct.setDescription(product.getDescription());
                exitingProduct.setVendor(product.getVendor());
                exitingProduct.setPrice(product.getPrice());
                exitingProduct.setStock(product.getStock());
                exitingProduct.setCurrency(product.getCurrency());
                exitingProduct.setImage_url(product.getImage_url());
                exitingProduct.setSku(product.getSku());
                Product savedProduct = productRepository.save(exitingProduct);
                return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
    }

    //to delete the product with the id as path variable
    // ok 200
    //bad request 400

    public ResponseEntity<Object> deleteProductById(int id) {
       if(!productRepository.existsById(id)){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
       try{
           productRepository.deleteById(id);
           return ResponseEntity.status(HttpStatus.OK).build();
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
    }

}
