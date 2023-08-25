package com.codegym.cart.service;

import com.codegym.cart.model.Product;
import com.codegym.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }
}
