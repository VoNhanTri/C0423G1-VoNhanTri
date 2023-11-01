package com.example.connectbackend.service;

import com.example.connectbackend.model.Petro;
import com.example.connectbackend.repository.IPetroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetroService implements IPetroService {
    @Autowired
    private IPetroRepository iPetroRepository;


    @Override
    public List<Petro> getAll() {
        return iPetroRepository.findAll();
    }

    @Override
    public Petro add(Petro petro) {
        iPetroRepository.save(petro);
        return petro;
    }
}
