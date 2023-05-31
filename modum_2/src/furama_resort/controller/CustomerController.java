package furama_resort.controller;

import java.util.Scanner;

public class CustomerController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void customerManagement() {
        do {
            System.out.println("----Select Customer");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");

            int choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("mời nhập số");
                }catch (Exception e){
                    System.out.println("nhập lại");
                }
            }
            switch (choice){
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
                    System.out.println("mời nập lại");
            }
        } while (true);
    }
}
