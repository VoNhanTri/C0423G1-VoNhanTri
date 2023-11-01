package com.example.marian.service;

import com.example.marian.model.TypeCustomer;
import com.example.marian.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository iTypeRepository;


    @Override
    public List<TypeCustomer> findAllType() {
        return iTypeRepository.findAll();
    }
}
