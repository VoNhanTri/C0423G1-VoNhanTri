package com.example.ban_hang.product.service;

import com.example.ban_hang.product.model.Product;
import com.example.ban_hang.product.repository.IProductRepository;
import com.example.ban_hang.product.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private  static IProductRepository productRepository = new ProductRepository();
    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void delete(int id) {
    productRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> display() {
        return productRepository.display();
    }

    @Override
    public void edit(int id, Product product) {
        productRepository.edit(id, product);
    }

    @Override
    public List<Product> findName(String name) {
        return productRepository.findName(name);
    }




}
