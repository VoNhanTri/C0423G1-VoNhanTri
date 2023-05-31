package bai_tap_them.repository.impl;

import bai_tap_them.common.ReadAndWrite;
import bai_tap_them.model.impl.Teacher;
import bai_tap_them.repository.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private static List<Teacher> teacherList = new ArrayList<>();

    private static final String PATH_TEACHER = "src/bai_tap_them/data/teacher.csv";

    @Override
    public List<Teacher> getAllTeacher() {
        List<String> strings = ReadAndWrite.readFile(PATH_TEACHER);
        teacherList.clear();
        String[] info;
        for (String s : strings) {
            info = s.split(",");
            teacherList.add(new Teacher(info[0], info[1], info[2], info[3], info[4]));
        }
        return teacherList;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        List<String> strings = new ArrayList<>();
        strings.add(teacher.getId() + "," + teacher.getName() + "," + teacher.getDate() + "," + teacher.getGender() + "," + teacher.getSpecialize());
        ReadAndWrite.writeFile(PATH_TEACHER, strings, true);
    }


    @Override
    public void removeTeacher(Teacher teacher) {
        teacherList = getAllTeacher();
        teacherList.remove(teacher);
        List<String> strings = new ArrayList<>();
        for (Teacher temp : teacherList) {
            strings.add(temp.getId() + "," + temp.getName() + "," + temp.getDate() + "," + temp.getGender() + "," + temp.getSpecialize());
        }
    }

    @Override
    public Teacher getByIDTeacher(String id) {
        teacherList = getAllTeacher();
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null;
    }
}
