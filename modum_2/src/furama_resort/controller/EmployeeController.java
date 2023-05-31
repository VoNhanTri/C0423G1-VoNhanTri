package furama_resort.controller;

import java.util.Scanner;

public class EmployeeController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void employeeManagement() {
        do {
            System.out.println("----Select Employee");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
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
                    System.out.println("display");
                    break;
                case 2:
                    System.out.println("add");
                    break;
                case 3:
                    System.out.println("edit");
                    break;
                case 4:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("nhập lại");
                    break;
            }
        } while (true);
    }
}
