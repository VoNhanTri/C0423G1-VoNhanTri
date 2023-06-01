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

    @Override
    public void editEmployee(Employee employee, int index) {
        List<String> list = ReadAndWrite.readFile(PATH_EMPLOYEE);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(employee.getCode())) {
                employeeList.set(i, employee);
                ReadAndWrite.writeFile(PATH_EMPLOYEE,list,false);
            }
        }

    }

    @Override
    public void removeEmployee(Employee employee) {
        employeeList = getAllEmployee();
        employeeList.remove(employee);
        List<String> strings = new ArrayList<>();
        for (Employee temp: employeeList) {
            strings.add(temp.getCode()+","+temp.getName()+","+temp.getDate()+","+temp.getGender()+","+temp.getIdentityCard()+","+temp.getNumberPhone()+","+temp.getEmail()+","+temp.getLevel()+","+temp.getPosition()+","+temp.getSalary());
        }
        ReadAndWrite.writeFile(PATH_EMPLOYEE,strings,false);
    }

    @Override
    public void searchEmployee(String name) {

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
