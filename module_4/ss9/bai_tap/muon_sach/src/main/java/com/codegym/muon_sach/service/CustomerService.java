package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Customer;
import com.codegym.muon_sach.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findCustomer() {
        return iCustomerRepository.findAll();
    }
}
