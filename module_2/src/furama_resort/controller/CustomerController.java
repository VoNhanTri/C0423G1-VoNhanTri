package furama_resort.controller;

import furama_resort.service.ICustomerService;
import furama_resort.service.impl.CustomerService;

import java.util.Scanner;

public class CustomerController {
    private static final Scanner scanner = new Scanner(System.in);
    private  static final ICustomerService customerService = new CustomerService();

    public static void customerManagement() {
        do {
            System.out.println("----Select Customer");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Search customer");
            System.out.println("6. Return main menu");

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
                    customerService.disPlayAllCustomer();
                    break;
                case 2:
                    customerService.addCustomer();
                    break;
                case 3:
                    customerService.editCustomer();
                    break;
                case 4:
                    customerService.deleteCustomer();
                    break;
                case 5:
                    customerService.findCustomer();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("mời nập lại");
                    break;
            }
        } while (true);
    }
}
