package com.example.backend.service;

import com.example.backend.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(String name);


    void create(Product product);
}
