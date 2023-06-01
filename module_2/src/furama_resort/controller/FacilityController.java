package furama_resort.controller;

import java.util.Scanner;

public class FacilityController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void facilityManagement() {

        do {
            System.out.println("----Select Facility");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            int choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (NumberFormatException numberFormatException){
                    System.out.println("mời nhập số");
                }catch (Exception e){
                    System.out.println("nhap lai");
                }
            }
            switch (choice){
                case 1:
                    System.out.println("1 Display list facility");
                    break;
                case 2:
                    System.out.println("add");
                    break;
                case 3:
                    System.out.println("display list");
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
