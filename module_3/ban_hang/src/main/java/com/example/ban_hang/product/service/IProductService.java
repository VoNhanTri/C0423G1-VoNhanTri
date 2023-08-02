package com.example.ban_hang.product.service;

import com.example.ban_hang.product.dto.ProductListDto;

import java.util.List;

public interface IProductService {

    List<ProductListDto> getAllDto();

    void add(ProductListDto productListDto);

    void delete(int id);
}
