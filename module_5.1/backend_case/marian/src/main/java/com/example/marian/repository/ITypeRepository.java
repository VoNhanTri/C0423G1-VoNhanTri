package com.example.marian.repository;

import com.example.marian.model.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<TypeCustomer,Integer> {
}
