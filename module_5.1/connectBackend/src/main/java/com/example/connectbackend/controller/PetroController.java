package com.example.connectbackend.controller;

import com.example.connectbackend.model.Petro;
import com.example.connectbackend.service.IPetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping
public class PetroController {
    @Autowired
    private IPetroService iPetroService;

    @GetMapping("/petrols")
    public ResponseEntity<?> getAll() {
        List<Petro> petroList = iPetroService.getAll();
        return new ResponseEntity<>(petroList, HttpStatus.OK);
    }

    @PostMapping("/petrols")
    public ResponseEntity<?> add (@RequestBody Petro petro){
        try{
            Petro petro1 = iPetroService.add(petro);
            return new ResponseEntity<>(petro1,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Lỗi",HttpStatus.INTERNAL_SERVER_ERROR);
        }
       }

}
