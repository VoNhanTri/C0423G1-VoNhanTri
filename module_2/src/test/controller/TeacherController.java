package test.controller;

import test.service.ITeacherService;
import test.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private static Scanner scanner = new Scanner(System.in);
    private static ITeacherService teacherService = new TeacherService();
    public static void menu(){
        do {
            System.out.println("--- He thong quan ly giao vien");
            System.out.println("1. Them giao vien");
            System.out.println("2. Xoa giao vien");
            System.out.println("3. Hien thi danh sach");
            System.out.println("4. Thoat");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    teacherService.addTeacher();
                    break;
                case "2":
                    teacherService.deleteTeacher();
                    break;
                case "3":
                    teacherService.displayAll();
                    break;
                case "4":
                    System.exit(1);
                    break;
                default:
                    System.out.println("moi ban nhap tu 1 den 4");
                    break;
            }
        }while (true);

    }
}
