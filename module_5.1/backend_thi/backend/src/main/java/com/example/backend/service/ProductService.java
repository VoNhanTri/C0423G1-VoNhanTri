package com.example.backend.service;

import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll(String name) {
        return productRepository.findProductByNameContaining(name);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }


}
