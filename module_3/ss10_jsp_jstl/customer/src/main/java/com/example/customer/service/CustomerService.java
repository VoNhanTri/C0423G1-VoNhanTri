package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "join", "join@gmail.com", "Ha Noi"));
        customerMap.put(2, new Customer(2, "bill", "bill@gmail.com", "Ha Noi"));
        customerMap.put(3, new Customer(3, "alex", "alex@gmail.com", "Ha Noi"));
        customerMap.put(4, new Customer(4, "adam", "adam@gmail.com", "Ha Noi"));
        customerMap.put(5, new Customer(5, "rose", "rose@gmail.com", "Ha Noi"));
    }

    @Override
    public List<Customer> display() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void add(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public void edit(int id, Customer customer) {
        customerMap.put(id, customer);

    }

    @Override
    public void delete(int id) {
        customerMap.remove(id);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }
}
