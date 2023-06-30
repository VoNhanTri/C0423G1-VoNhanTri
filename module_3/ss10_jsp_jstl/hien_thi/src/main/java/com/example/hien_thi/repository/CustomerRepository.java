package com.example.hien_thi.repository;

import com.example.hien_thi.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private  static List<Customer> customerList = new ArrayList<>();
    static {
        Customer customer = new Customer(1,"Vo Nhan Tri","24/09/1994","quang ngai","#");
        Customer customer1 = new Customer(2,"Vo van A","04/05/1994","quang ngai","#");
        Customer customer2 = new Customer(3,"Vo Van B","21/07/1994","quang ngai","#");
        customerList.add(customer);
        customerList.add(customer1);
        customerList.add(customer2);
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
