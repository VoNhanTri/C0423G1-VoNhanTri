package com.example.backend.service;

import com.example.backend.model.TypeProduct;
import com.example.backend.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService{
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public List<TypeProduct> findAllType() {
        return typeRepository.findAll() ;
    }
}
