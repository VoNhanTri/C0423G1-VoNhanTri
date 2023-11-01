package com.example.connectbackend.repository;

import com.example.connectbackend.model.Petro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetroRepository extends JpaRepository<Petro,Integer> {
}
