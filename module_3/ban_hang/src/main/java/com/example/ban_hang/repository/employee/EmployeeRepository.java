package com.example.ban_hang.repository.employee;

import com.example.ban_hang.model.employee.Employee;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String DELETE = " delete from employees where employee_id =? ";
    private static final String ADD = " insert into employees(employee_name,employee_salary,employee_gender,employee_birthday,employee_phone,account_email,employee_adress,employee_status,employee_image)values(?,?,?,?,?,?,?,?,?) ";
    private static final String DISPLAY = " select*from employees ";
    private static final String EDIT = " update employees set employee_name=?,employee_salary=?,employee_gender=?,employee_birthday=?,employee_phone=?,account_email=?,employee_adress=?,employee_status=?,employee_image=? where employee_id =?";
    private static final String FIND_NAME = " select*from employee where employee_name like ? ";
    private static final String FIND_ID = " select employee_id,employee_name,employee_salary,employee_gender,employee_birthday,employee_phone,account_email,employee_adress,employee_status,employee_image from employee where employee_id = ?";
    @Override
    public List<Employee> display() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void edit(int id, Employee employee) {

    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }
}
