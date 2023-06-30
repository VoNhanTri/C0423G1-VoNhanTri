package com.example.hien_thi.service;

import com.example.hien_thi.model.Customer;
import com.example.hien_thi.repository.CustomerRepository;
import com.example.hien_thi.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private static ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
