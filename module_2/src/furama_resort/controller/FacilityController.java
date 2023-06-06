package furama_resort.controller;

import furama_resort.service.IFacilityService;
import furama_resort.service.impl.FacilityService;

import java.util.Scanner;

public class FacilityController {
    private static final Scanner scanner = new Scanner(System.in);
    private static IFacilityService facilityService = new FacilityService();

    public static void facilityManagement() {

        do {
            System.out.println("----Select Facility");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Delete facility");
            System.out.println("4. Display list facility maintenance");
            System.out.println("5. Return main menu");
            int choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("mời nhập số");
                } catch (Exception e) {
                    System.out.println("nhap lai");
                }
            }
            switch (choice) {
                case 1:
                    facilityService.displayFacility();
                    break;
                case 2:
                    facilityService.addFacility();
                    break;
                case 3:
                    facilityService.deleteFacility();
                    break;
                case 5:
                   return;
                default:
                    System.out.println("nhập lại");
                    break;
            }
        } while (true);
    }
}
