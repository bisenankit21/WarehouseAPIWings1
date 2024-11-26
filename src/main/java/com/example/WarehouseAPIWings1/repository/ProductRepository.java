package com.example.WarehouseAPIWings1.repository;

import com.example.WarehouseAPIWings1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsBySku(String sku);
    List<Product> findByVendor(String value);
}
