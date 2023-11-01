package com.example.connectbackend.service;

import com.example.connectbackend.model.Petro;

import java.util.List;

public interface IPetroService {
    List<Petro> getAll();

    Petro add(Petro petro);
}
