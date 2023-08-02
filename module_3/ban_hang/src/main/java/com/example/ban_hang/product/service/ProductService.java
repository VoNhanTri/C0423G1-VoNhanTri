package com.example.ban_hang.product.service;

import com.example.ban_hang.product.dto.ProductListDto;
import com.example.ban_hang.product.repository.IProductRepository;
import com.example.ban_hang.product.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private static IProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductListDto> getAllDto() {
        return productRepository.getAllDto();
    }

    @Override
    public void add(ProductListDto productListDto) {
        productRepository.add(productListDto);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }
}
