package test.repository;

import test.model.Teacher;

import java.util.List;

public interface ITeacherRepository {
    List<Teacher> getAllTeacher();
    void deleteTeacher(Teacher teacher);
    void addTeacher(Teacher teacher);
    Teacher getByCOde(String code);
}
