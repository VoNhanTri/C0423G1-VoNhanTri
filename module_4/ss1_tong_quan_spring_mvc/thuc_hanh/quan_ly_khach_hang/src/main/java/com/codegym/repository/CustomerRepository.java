package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Tri","tri@gmail.com","Quang Ngai"));
        customerList.add(new Customer(2,"Tri","tri@gmail.com","Quang Ngai"));
        customerList.add(new Customer(3,"Tri","tri@gmail.com","Quang Ngai"));
    }
    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
