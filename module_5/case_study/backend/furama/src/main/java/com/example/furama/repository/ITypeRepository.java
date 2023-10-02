package com.example.furama.repository;

import com.example.furama.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<Type,Integer> {
}
