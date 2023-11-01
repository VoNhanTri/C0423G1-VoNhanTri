package com.example.marian.repository;

import com.example.marian.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findCustomerByNameContaining(Pageable pageable, String name);

//    @Query(value = "SELECT * from customer where name like :name ", nativeQuery = true)
//    Page<Customer> findAllCustomer(Pageable pageable, String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM customer WHERE (id = :id )", nativeQuery = true)
    void deleteById(int id);

}
