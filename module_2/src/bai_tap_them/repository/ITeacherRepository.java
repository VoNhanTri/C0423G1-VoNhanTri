package bai_tap_them.repository;

import bai_tap_them.model.impl.Teacher;

import java.util.List;

public interface ITeacherRepository {

    List<Teacher> getAllTeacher();

    void addTeacher(Teacher teacher);

    void removeTeacher(Teacher teacher);

    Teacher getByIDTeacher(String id);

}
