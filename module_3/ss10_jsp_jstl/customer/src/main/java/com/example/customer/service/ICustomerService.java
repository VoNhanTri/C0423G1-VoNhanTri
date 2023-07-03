package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> display();
    void add(Customer customer);
    void edit(int id, Customer customer);
    void delete(int id);
    Customer findById(int id);
}
