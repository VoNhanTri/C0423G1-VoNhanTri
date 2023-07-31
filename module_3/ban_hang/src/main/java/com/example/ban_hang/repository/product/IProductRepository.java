package com.example.ban_hang.repository.product;

import com.example.ban_hang.model.product.Product;

import java.util.List;

public interface IProductRepository {
    void add(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> display();
    void edit(int id, Product product);
    List<Product> findName(String name);
}
