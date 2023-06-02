package furama_resort.repository.impl;

import furama_resort.common.ReadAndWrite;
import furama_resort.model.person.Customer;
import furama_resort.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    private static final String PATH_CUSTOMER = "src/furama_resort/data/customer.csv";

    @Override
    public List<Customer> getAllCustomer() {
        List<String> strings = ReadAndWrite.readFile(PATH_CUSTOMER);
        customerList.clear();
        String[] info;
        for (String s : strings) {
            info = s.split(",");
            customerList.add(new Customer(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7],info[8]));
        }
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        List<String> strings = new ArrayList<>();
        strings.add(customer.getCode() + "," + customer.getName() + "," + customer.getDate() + "," + customer.getGender() + "," + customer.getIdentityCard() + "," + customer.getNumberPhone() + "," + customer.getEmail() + "," + customer.getCustomerType()+","+customer.getAddress());
        ReadAndWrite.writeFile(PATH_CUSTOMER, strings, true);
    }

    @Override
    public void editCustomer() {
        //String code, String name, String date, String gender, String identityCard, String numberPhone, String email, String customerType
        List<String> list = new ArrayList<>();
        for (Customer temp: customerList) {
            list.add(temp.getCode()+","+temp.getName()+","+temp.getDate()+","+temp.getGender()+","+temp.getIdentityCard()+","+temp.getNumberPhone()+","+temp.getEmail()+","+temp.getCustomerType()+","+temp.getAddress());
        }
        ReadAndWrite.writeFile(PATH_CUSTOMER, list, false);
    }

    @Override
    public void upEditCustomer() {
        customerList = getAllCustomer();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerList = getAllCustomer();
        customerList.remove(customer);
        List<String> strings =new ArrayList<>();
        for (Customer temp: customerList) {
            strings.add(temp.getCode()+","+temp.getName()+","+temp.getDate()+","+temp.getGender()+","+temp.getIdentityCard()+","+temp.getNumberPhone()+","+temp.getEmail()+","+temp.getCustomerType()+","+temp.getAddress());
        }
        ReadAndWrite.writeFile(PATH_CUSTOMER,strings,false);
    }

    @Override
    public void searchCustomer(String name) {
        customerList =getAllCustomer();
        for (Customer find: customerList) {
            if (find.getName().contains(name)){
                System.out.println(find);
            }
        }
    }

    @Override
    public Customer getByCodeCustomer(String code) {
        customerList = getAllCustomer();
        for (Customer customer: customerList) {
            if (customer.getCode().equals(code)){
                return customer;
            }
        }
        return null;
    }
}
