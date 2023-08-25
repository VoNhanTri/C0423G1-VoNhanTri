package com.codegym.cart.repository;

import com.codegym.cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository <Product,Integer> {
    @Query(value = "select * from  product where id =:id",nativeQuery = true)
    Product findById(@Param(value = "id") Long id);
}
