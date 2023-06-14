package test.service.impl;

import test.common.ReadAndWrite;
import test.model.Teacher;
import test.repository.ITeacherRepository;
import test.repository.impl.TeacherRepository;
import test.service.ITeacherService;

import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static ITeacherRepository teacherRepository = new TeacherRepository();
    @Override
    public void displayAll() {
        List<Teacher> teachers = teacherRepository.getAllTeacher();
        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void deleteTeacher() {
        System.out.println("moi ban nhap ma gia vien muon xoa");
        String code = scanner.nextLine();
        Teacher teacher = teacherRepository.getByCOde(code);
        if (teacher == null){
            System.out.println("ma ko ton tai");
        }else {
            System.out.println("Ban co muon xoa giao vien co ten " + teacher.getName());
            System.out.println("1. xoa");
            System.out.println("2. khong xoa");
        }
        String choice = scanner.nextLine();
        if (choice.equals("1")){
            teacherRepository.deleteTeacher(teacher);
            System.out.println("xoa thanh cong");
        }

    }

    @Override
    public void addTeacher() {
        System.out.println("moi ban nhap ma giaop vien ");
        String code = scanner.nextLine();
        System.out.println("moi ban nhap ten");
        String name = scanner.nextLine();
        System.out.println("moi ban nhap ngay thang nam sinh");
        String date = scanner.nextLine();
        System.out.println("moi ban nhap dia chi");
        String dress = scanner.nextLine();
        Teacher teacher = new Teacher(code,name,date,dress);
        teacherRepository.addTeacher(teacher);
    }
}
