package furama_resort.controller;

import java.util.Scanner;

public class FuramaController {
  private static final  Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu() {

        do {
            System.out.println("----Quản Lý Resort Furama");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("nhập số");
                }catch (Exception e){
                    System.out.println("Lỗi");
                }
            }
            switch (choice) {
                case 1:
                    EmployeeController.employeeManagement();
                    break;
                case 2:
                    CustomerController.customerManagement();
                    break;
                case 3:
                    FacilityController.facilityManagement();
                    break;
                case 4:
                    BookingController.bookingManagement();
                    break;
                case 5:
                    PromotionController.promotionManagement();
                    break;
                case 6:
                    System.out.println(" Exit");
                    System.exit(1);
                    break;
                default:
                    System.out.println("nhập lại");
                    break;
            }
        } while (true);
    }
}
