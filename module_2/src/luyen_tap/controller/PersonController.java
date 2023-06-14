package luyen_tap.controller;


import luyen_tap.service.IPersonService;
import luyen_tap.service.impl.PersonService;

import java.util.Scanner;

public class PersonController {
    private static Scanner scanner = new Scanner(System.in);
    private static IPersonService personService = new PersonService();
    public static void menu(){
        do {
            System.out.println("-- he thong quan ly san pham");
            System.out.println("1. them san pham");
            System.out.println("2. xoa san pham");
            System.out.println("3. hien thi san pham");
            System.out.println("4. thoat");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    personService.add();
                    break;
                case "2":
                    personService.delete();
                    break;
                case "3":
                    personService.displayAll();
                    break;
                case "4":
                    System.exit(1);
                    break;
                default:
                    System.out.println("moi ban nhap tuw 1 den 4");
            }
        }while (true);

    }
}
