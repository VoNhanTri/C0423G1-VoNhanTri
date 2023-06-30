package com.example.hien_thi.repository;

import com.example.hien_thi.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
}
