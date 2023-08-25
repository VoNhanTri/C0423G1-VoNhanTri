package com.codegym.cart.service;

import com.codegym.cart.model.Product;

import java.util.List;

public interface IProductService {
    Product findById(Long id);

    List<Product> findAll();
}
