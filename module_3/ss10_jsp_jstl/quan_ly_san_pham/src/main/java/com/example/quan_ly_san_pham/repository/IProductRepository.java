package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> display();
    void add(Product product);
    Product findById(int id);
    void delete(Product product);
    void edit(int id,Product product);
    Product findName(String name);
}
