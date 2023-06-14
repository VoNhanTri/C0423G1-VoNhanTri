package bai_test.repository;

import bai_test.model.Student;

import java.util.List;

public interface IStudentRepository {
    void deleteStudent(Student student);
    void addStudent(Student student);
    List<Student> getAllStudent();
    Student getByCode(String code);
}
