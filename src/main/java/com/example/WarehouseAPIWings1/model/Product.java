package com.example.WarehouseAPIWings1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String vendor;
    private int price;
    private int stock;
    private String currency;
    private String image_url;

    @Column(unique = true)
    private String sku;



}
