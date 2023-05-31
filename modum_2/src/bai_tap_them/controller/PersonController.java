package bai_tap_them.controller;

import bai_tap_them.service.IStudentService;
import bai_tap_them.service.ITeacherService;
import bai_tap_them.service.impl.StudentService;
import bai_tap_them.service.impl.TeacherService;

import java.util.Scanner;

public class PersonController {
    private static final Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();
    private static ITeacherService teacherService = new TeacherService();

    public static void menu() {
        do {
            System.out.println("--Chương Trình Quản Lý Sinh Viên");
            System.out.println("Chọn Chức Năng Theo Số Để Tiếp Tục");
            System.out.println("1. Thêm Mới Giảng Viên Hoặc Sinh Viên");
            System.out.println("2. Xóa Giảng Viên Hoặc Sinh Viên");
            System.out.println("3. Xem Danh Sách Giảng Viên Hoặc Sinh Viên");
            System.out.println("4. Thoát");
            System.out.println("Chọn chức Năng");
            int choice;
            int chose;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("vui lòng nhập số");
                }
            }
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("Mời bạn nhập số");
                        System.out.println("1. Thêm học sinh");
                        System.out.println("2. Thêm giáo viên");
                        try {
                            chose = Integer.parseInt(scanner.nextLine());
                            switch (chose) {
                                case 1:
                                    studentService.addStudent();
                                    break;
                                case 2:
                                    teacherService.addTeacher();
                                    break;
                                default:
                                    System.out.println("vui lòng nhập lại số 1 hoặc số 2");
                                    break;
                            }
                            break;
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("vui lòng nhập số");
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("Mời bạn nhập số");
                        System.out.println("1. xoá học sinh");
                        System.out.println("2. xoá giáo viên");
                        try {
                            chose = Integer.parseInt(scanner.nextLine());
                            switch (chose) {
                                case 1:
                                    studentService.deleteStudent();
                                    break;
                                case 2:
                                    teacherService.deleteTeacher();
                                    break;
                                default:
                                    System.out.println("mời nhâp lại số 1 hoặc số 2");
                                    break;
                            }
                            break;
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("mời bạn nhập số");
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("mời bạn nhập số");
                        System.out.println("1. xem danh sách học sinh");
                        System.out.println("2. xem danh sách giáo viên");
                        try {
                            chose = Integer.parseInt(scanner.nextLine());
                            switch (chose) {
                                case 1:
                                    studentService.disPlayAllStudent();
                                    break;
                                case 2:
                                    teacherService.disPlayAllTeacher();
                                    break;
                                default:
                                    System.out.println("mời bạn nhập lại số 1 hoặc 2");
                                    break;
                            }
                            break;
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("vui lòng nhập số");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thoát Chương Trình");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
                    break;
            }
        } while (true);
    }
}
