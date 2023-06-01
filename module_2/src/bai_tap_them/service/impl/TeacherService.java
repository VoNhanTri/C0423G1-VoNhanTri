package bai_tap_them.service.impl;

import bai_tap_them.model.impl.Teacher;
import bai_tap_them.repository.ITeacherRepository;
import bai_tap_them.repository.impl.TeacherRepository;
import bai_tap_them.service.ITeacherService;

import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static ITeacherRepository teacherRepository = new TeacherRepository();

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
        System.out.println("nhập mã giáo viên mốn xóa");
        String id = scanner.nextLine();
        Teacher teacher = teacherRepository.getByIDTeacher(id);
        if (teacher==null){
            System.out.println("Mã giáo viên không đúng");
        }else {
            System.out.println("bạn có muốn xóa giáo viên với tên: " + teacher.getName());
            System.out.println("1. Xóa");
            System.out.println("2. Không xóa");
        }
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice==1){
            teacherRepository.removeTeacher(teacher);
            System.out.println("Xóa thành công");
        }
    }

}
