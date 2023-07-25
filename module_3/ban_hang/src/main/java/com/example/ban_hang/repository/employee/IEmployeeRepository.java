package com.example.ban_hang.repository.employee;

import com.example.ban_hang.model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> display();
    void delete(int id);
    void add(Employee employee);
    Employee findById(int id);
    void edit(int id,Employee employee);
    List<Employee> findByName(String name);
}
