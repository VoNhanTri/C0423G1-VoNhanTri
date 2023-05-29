package bai_tap_them.service.impl;

import bai_tap_them.model.Person;
import bai_tap_them.model.impl.Student;
import bai_tap_them.model.impl.Teacher;
import bai_tap_them.repository.IPersonRepository;
import bai_tap_them.repository.impl.TeacherRepository;
import bai_tap_them.service.IPersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class TeacherService implements IPersonService {
    private static Scanner scanner = new Scanner(System.in);
    private static IPersonRepository teacherRepository = new TeacherRepository() {
        @Override
        public List<Student> getAllStudent() {
            return null;
        }

        @Override
        public void addStudent(Student student) {

        }

        @Override
        public void removeStudent(Student student) {

        }

        @Override
        public Student getByIDStudent(String id) {
            return null;
        }
    };

    @Override
    public void disPlayAllTeacher() {
        List<Teacher> teachers = teacherRepository.getAllTeacher();
        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }
    }
    @Override
    public void addTeacher() {
        System.out.println("Nhập mã mới của giáo viên");
        String id = scanner.nextLine();
        System.out.println("Nhập tên mới của giáo viên");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh mới của giáo viên");
        String date = scanner.nextLine();
        System.out.println("Nhập giới tính ");
        String gender = scanner.nextLine();
        System.out.println("Nhập chuyên môn");
        String specialize = scanner.nextLine();
        Teacher teacher = new Teacher(id,name,date,gender,specialize);
        teacherRepository.addTeacher(teacher);
    }

    @Override
    public void deleteTeacher() {

    }

}
