package furama_resort.repository;

import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomer();
    void addCustomer(Customer customer);
    void editCustomer();
    void upEditCustomer();
    void deleteCustomer(Customer customer);
    void searchCustomer(String name);
    Customer getByCodeCustomer(String code);
}
