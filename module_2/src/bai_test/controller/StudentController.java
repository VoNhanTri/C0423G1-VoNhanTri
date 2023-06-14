package bai_test.controller;

import bai_test.service.IStudentService;
import bai_test.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();

    public static void Menu() {
        do {
            System.out.println("---He thoing quan ly hoc sinh----");
            System.out.println("1. Them Hoc Sinh");
            System.out.println("2, Xoa hoc sinh");
            System.out.println("3. Hien thi danh sach");
            System.out.println("4. Thoat");
            String choice = "";
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    studentService.addStudent();
                    break;
                case "2":
                    studentService.deleteStudent();
                    break;
                case "3":
                    studentService.displayAll();
                    break;
                case "4":
                    System.exit(1);
                    break;
                default:
                    System.out.println("moi nhap tu 1 den 4");
                    break;
            }
        } while (true);
    }
}
