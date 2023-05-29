package bai_tap_them.repository;

import bai_tap_them.model.Person;
import bai_tap_them.model.impl.Student;
import bai_tap_them.model.impl.Teacher;

import java.util.List;

public interface IPersonRepository {
    List<Student> getAllStudent();
    List<Teacher> getAllTeacher();
    void addStudent(Student student);
    void addTeacher(Teacher teacher);
    void removeStudent(Student student);
    void removeTeacher(Teacher teacher);
    Student getByIDStudent(String id);
    Teacher getByIDTeacher(String id);

}
