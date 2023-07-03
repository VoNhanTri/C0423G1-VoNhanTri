package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"banh",15000,"banh chocolate","Orion"));
        productList.add(new Product(2,"keo",10000,"keo chocolate","Orion"));
        productList.add(new Product(3,"snack",5000,"snack chocolate","Orion"));
    }
    @Override
    public List<Product> display() {
        return productList;
    }

    @Override
    public void add(Product product) {
    productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void delete(Product product) {
    productList.remove(product);
    }

}
