package furama_resort.repository.impl;

import furama_resort.common.ReadAndWrite;
import furama_resort.model.person.Employee;
import furama_resort.repository.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> employeeList = new ArrayList<>();
    private static final String PATH_EMPLOYEE = "src/furama_resort/data/employee.csv";


    @Override
    public List<Employee> getAllEmployee() {
        List<String> strings = ReadAndWrite.readFile(PATH_EMPLOYEE);
        employeeList.clear();
        String[] info;
        for (String s : strings) {
            info = s.split(",");
            employeeList.add(new Employee(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], Float.parseFloat(info[9])));
        }
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        List<String> strings = new ArrayList<>();
        strings.add(employee.getCode() + "," + employee.getName() + "," + employee.getDate() + "," + employee.getGender() + "," + employee.getIdentityCard() + "," + employee.getNumberPhone() + "," + employee.getEmail() + "," + employee.getLevel() + "," + employee.getPosition() + "," + employee.getSalary());
        ReadAndWrite.writeFile(PATH_EMPLOYEE, strings, true);
    }

    public void upEditEmployee() {
        employeeList = getAllEmployee();
    }

    @Override
    public void editEmployee() {
        List<String> list = new ArrayList<>();
        for (Employee temp : employeeList) {
            list.add(temp.getCode() + "," + temp.getName() + "," + temp.getDate() + "," + temp.getGender() + "," + temp.getIdentityCard() + "," + temp.getNumberPhone() + "," + temp.getEmail() + "," + temp.getLevel() + "," + temp.getPosition() + "," + temp.getSalary());
        }
        ReadAndWrite.writeFile(PATH_EMPLOYEE, list, false);
    }

    @Override
    public void removeEmployee(Employee employee) {
        employeeList = getAllEmployee();
        employeeList.remove(employee);
        List<String> strings = new ArrayList<>();
        for (Employee temp : employeeList) {
            strings.add(temp.getCode() + "," + temp.getName() + "," + temp.getDate() + "," + temp.getGender() + "," + temp.getIdentityCard() + "," + temp.getNumberPhone() + "," + temp.getEmail() + "," + temp.getLevel() + "," + temp.getPosition() + "," + temp.getSalary());
        }
        ReadAndWrite.writeFile(PATH_EMPLOYEE, strings, false);
    }

    @Override
    public void searchEmployee(String name) {
        employeeList = getAllEmployee();
        for (Employee find: employeeList) {
            if (find.getName().contains(name)){
                System.out.println(find);
            }
        }
    }

    @Override
    public Employee getByCodeEmployee(String code) {
        employeeList = getAllEmployee();
        for (Employee employee : employeeList) {
            if (employee.getCode().equals(code)) {
                return employee;
            }
        }
        return null;
    }
}
