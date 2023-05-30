package bai_tap_them.repository.impl;

import bai_tap_them.model.impl.Student;
import bai_tap_them.repository.IStudentRepository;
import bai_tap_them.repository.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;

public  class StudentRepository implements IStudentRepository {
    private static List<Student> studentsList = new ArrayList<>();
    static {
        studentsList.add(new Student("001","Võ Nhân Trí","24/09/2012","Nam","C3323",10));
        studentsList.add(new Student("002","Trần Thị Bê","12/12/2012","Nữ","C3323",9));
        studentsList.add(new Student("003","Nguyễn Văn A","02/01/2012","Nam","C3323",8));
    }
    @Override
    public List<Student> getAllStudent() {
        return studentsList;
    }

    @Override
    public void addStudent(Student student) {
        studentsList.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentsList.remove(student);
    }

    @Override
    public Student getByIDStudent(String id) {
        for (Student student: studentsList) {
            if (student.getId().equals(id));
            return student;
        }
        return null;
    }
}
