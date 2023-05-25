package bai_tap_them.controller;

import bai_tap_them.service.IPersonService;
import bai_tap_them.service.impl.StudentService;

import java.util.Scanner;

public class PersonController {
    private static final Scanner scanner = new Scanner(System.in);
    private static IPersonService studentService = new StudentService();

   public static void menu(){
       do {
           System.out.println("--Chương Trình Quản Lý Sinh Viên");
           System.out.println("Chọn Chức Năng Theo Số Để Tiếp Tục");
           System.out.println("1. Thêm Mới Giảng Viên Hoặc Sinh Viên");
           System.out.println("2. Xóa Giảng Viên Hoặc Sinh Viên");
           System.out.println("3. Xem Danh Sách Giảng Viên Hoặc Sinh Viên");
           System.out.println("4. Thoát");
           System.out.println("Chọn chức Năng");
           int choice = Integer.parseInt(scanner.nextLine());
           switch (choice){
               case 1:
                   studentService.addPerson();
                   break;
               case 2:
                   studentService.deletePerson();
                   break;
               case 3:
                   studentService.disPlayAll();
                   break;
               case 4:
                   System.out.println("xin cảm ơn");
                   System.exit(1);
                   break;
               default:
                   System.out.println("mời nhập lại ");
           }
       }while (true);
   }
}