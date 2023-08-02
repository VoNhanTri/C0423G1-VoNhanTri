package com.example.ban_hang.product.repository;

import com.example.ban_hang.product.dto.ProductListDto;

import java.util.List;

public interface IProductRepository {
    List<ProductListDto> getAllDto();

    void add(ProductListDto productListDto);

    void delete(int id);
}
