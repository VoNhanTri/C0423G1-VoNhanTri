package com.example.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private int quantity;
    private int price;
    private String date;
    private String description;
    @ManyToOne
    @JoinColumn(name = "type_Id",referencedColumnName = "id")
    private TypeProduct typeProduct;

    public Product() {
    }

    public Product(int id, String code, String name, int quantity, int price, String date, String description, TypeProduct typeProduct) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.description = description;
        this.typeProduct = typeProduct;
    }
}
