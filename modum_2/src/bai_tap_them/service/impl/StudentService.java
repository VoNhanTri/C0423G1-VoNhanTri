package bai_tap_them.service.impl;

import bai_tap_them.model.impl.Student;
import bai_tap_them.repository.IStudentRepository;
import bai_tap_them.repository.impl.StudentRepository;
import bai_tap_them.service.IStudentService;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IStudentRepository studentRepository = new StudentRepository();


    @Override
    public void disPlayAllStudent() {
        List<Student> students = studentRepository.getAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }

    }

    @Override
    public void addStudent() {
        System.out.println("Nhập mã học sinh ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên học sinh");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh");
        String date = scanner.nextLine();
        System.out.println("Nhập giới tính ");
        String gender = scanner.nextLine();
        System.out.println("Nhập lớp học");
        String classes = scanner.nextLine();
        float point;
        while (true) {
            try {
                System.out.println("Nhập số điểm");
                point = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Mời bạn nhập số");
            }
        }
        Student student = new Student(id, name, date, gender, classes, point);
        studentRepository.addStudent(student);
    }

    @Override
    public void deleteStudent() {
            System.out.println("Mời bạn nhập mã học sinh mà bạn muốn xoá ");
            String id = scanner.nextLine();
            Student student = studentRepository.getByIDStudent(id);
            if (student == null) {
                System.out.println("Mã học sinh không đúng");
            } else {
                System.out.println("Bạn có muốn xoá học sinh với tên " + student.getName());
                System.out.println("1. Xoá");
                System.out.println("2. Suy nghĩ lại");
            }
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                studentRepository.removeStudent(student);
                System.out.println("xoá thành công");
            }
    }

}
