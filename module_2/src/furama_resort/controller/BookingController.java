package furama_resort.controller;

import java.util.Scanner;

public class BookingController {
    private static final Scanner scanner = new Scanner(System.in);
    public static void bookingManagement(){
        do {
            System.out.println("----Select Booking");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            int choice = 0;
            while (true){
                try {
                    choice=Integer.parseInt(scanner.nextLine());
                    break;
                }catch (NumberFormatException numberFormatException){
                    System.out.println("nhập số");
                }catch (Exception e){
                    System.out.println("Lỗi");
                }
            }
            switch (choice){
                case 1:
                    System.out.println("add  new");
                    break;
                case 2:
                    System.out.println("display");
                    break;
                case 3:
                    System.out.println("create");
                    break;
                case 4:
                    System.out.println("display list");
                    break;
                case 5:
                    System.out.println("edit contract");
                    break;
                case 6:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("nhập lại");
                    break;
            }
        }while (true);
    }
}
