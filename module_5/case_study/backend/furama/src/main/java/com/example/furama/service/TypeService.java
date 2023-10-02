package com.example.furama.service;

import com.example.furama.model.Type;
import com.example.furama.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeService implements ITypeService{
    @Autowired
    private ITypeRepository typeRepository;
    @Override
    public List<Type> findAllType() {
        return typeRepository.findAll();
    }
}
