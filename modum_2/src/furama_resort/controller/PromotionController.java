package furama_resort.controller;

import java.util.Scanner;

public class PromotionController {
    private static final Scanner scanner = new Scanner(System.in);
    public static void promotionManagement(){
        do {
            System.out.println("----Select Promotion");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            int choice = 0;
            while (true){
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (NumberFormatException numberFormatException){
                    System.out.println("nhập số");
                }catch (Exception e){
                    System.out.println("Lỗi");
                }
            }
            switch (choice){
                case 1:
                    System.out.println("display list service");
                    break;
                case 2:
                    System.out.println("display list voucher");
                    break;
                case 3:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("nhập lại");
            }
        }while (true);
    }
}
