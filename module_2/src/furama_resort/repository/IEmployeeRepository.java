package furama_resort.repository;

import furama_resort.model.person.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getAllEmployee();
    void addEmployee(Employee employee);
     void upEditEmployee();

    void editEmployee();

    void removeEmployee(Employee employee);
    void searchEmployee(String name);

    Employee getByCodeEmployee(String code);
}
