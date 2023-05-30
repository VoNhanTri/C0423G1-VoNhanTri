package bai_tap_them.repository.impl;

import bai_tap_them.model.impl.Teacher;
import bai_tap_them.repository.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private static List<Teacher> teacherList = new ArrayList<>();

    static {
        teacherList.add(new Teacher("101", "Lê Thị Hồng", "12/05/1980", "Nữ", "10"));
        teacherList.add(new Teacher("102", "Tô Hiệu", "02/05/1980", "Nam", "10"));
        teacherList.add(new Teacher("103", "Lan Anh", "12/05/1980", "Nữ", "10"));
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherList;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }


    @Override
    public void removeTeacher(Teacher teacher) {
    teacherList.remove(teacher);
    }

    @Override
    public Teacher getByIDTeacher(String id) {
        for (Teacher teacher: teacherList) {
            if (teacher.getId().equals(id)){
                return  teacher;
            }
        }
        return null;
    }
}
