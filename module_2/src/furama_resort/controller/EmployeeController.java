package furama_resort.controller;

import furama_resort.service.IEmployeeService;
import furama_resort.service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IEmployeeService  employeeService = new EmployeeService();

    public static void employeeManagement() {
        do {
            System.out.println("----Select Employee");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Search employee");
            System.out.println("6. Return main menu");
            int choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("mời bạn nhập số");
                } catch (Exception e) {
                    System.out.println("Nhập lại");
                }
            }
            switch (choice) {
                case 1:
                    employeeService.displayAllEmployee();
                    break;
                case 2:
                    employeeService.addEmployee();
                    break;
                case 3:
                    employeeService.editEmployee();
                    break;
                case 4:
                    employeeService.deleteEmployee();
                    break;
                case 5:
                    employeeService.searchEmployee();
                    break;
                case 6:
                  return;
                default:
                    System.out.println("nhập lại");
                    break;
            }
        } while (true);
    }
}
