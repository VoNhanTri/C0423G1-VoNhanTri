package com.codegym.quan_ly.repository;

import com.codegym.quan_ly.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void delete(int id);
}
