package com.example.ban_hang.service.product;

import com.example.ban_hang.model.product.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> display();
    void edit(int id, Product product);
    List<Product> findName(String name);
}
