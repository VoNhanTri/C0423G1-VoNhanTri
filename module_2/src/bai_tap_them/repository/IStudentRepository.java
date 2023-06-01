package bai_tap_them.repository;

import bai_tap_them.model.impl.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAllStudent();
    void addStudent(Student student);
    void removeStudent(Student student);
    Student getByIDStudent(String id);
}
