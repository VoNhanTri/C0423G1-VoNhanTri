package bai_test.service.impl;

import bai_test.comon.ReadAndWrite;
import bai_test.model.Student;
import bai_test.repository.IStudentRepository;
import bai_test.repository.impl.StudentRepository;
import bai_test.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentRepository studentRepository = new StudentRepository();

    @Override
    public void addStudent() {
        System.out.println("moi ban nhap Id");
        String code = scanner.nextLine();
        System.out.println("moi ban nhap ten");
        String name = scanner.nextLine();
        System.out.println("moi ban nhap ngay thang nam");
        String date = scanner.nextLine();
        System.out.println("moi  ban nhap lop");
        String classes = scanner.nextLine();
        Student student = new Student(code, name, date, classes);
        studentRepository.addStudent(student);

    }

    @Override
    public void deleteStudent() {
        System.out.println("moi ban nhap code hoc sinh muon xoa");
        String code = scanner.nextLine();
        Student student = studentRepository.getByCode(code);
        if (student == null) {
            System.out.println("ma hoc sinh ko duing");
        } else {
            System.out.println("ban co muon xoa");
            System.out.println("1. xoa");
            System.out.println("2. khong xoa");
        }
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            studentRepository.deleteStudent(student);
            System.out.println("xoa thanh cong");
        }
    }

    @Override
    public void displayAll() {
        List<Student> students = studentRepository.getAllStudent();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
