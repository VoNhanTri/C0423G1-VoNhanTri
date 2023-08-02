package com.example.ban_hang.product.service;

import com.example.ban_hang.product.model.ProductType;
import com.example.ban_hang.product.repository.IProductTypeRepository;
import com.example.ban_hang.product.repository.ProductTypeRepository;

import java.util.List;

public class ProductTypeService implements IProductTypeService{
    private static IProductTypeRepository productTypeRepository = new ProductTypeRepository();
    @Override
    public List<ProductType> getAllP() {
        return productTypeRepository.getAllP();
    }
}
