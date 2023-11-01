package com.example.marian.service;

import com.example.marian.model.Customer;
import com.example.marian.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable, String name) {
        return iCustomerRepository.findCustomerByNameContaining(pageable, name);
    }

    @Override
    public void deleteCustomer(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findAllById(int id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void editCustomer(int id, Customer customerData) {
        iCustomerRepository.save(customerData);
    }

    @Override
    public void createCustomer(Customer customerData) {
            iCustomerRepository.save(customerData);
    }

}
