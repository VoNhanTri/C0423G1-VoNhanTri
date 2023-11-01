package com.example.marian.service;

import com.example.marian.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable, String name);

    void deleteCustomer(int id);

    Customer findAllById(int id);

    void editCustomer(int id, Customer customerData);

    void createCustomer(Customer customerData);
}
