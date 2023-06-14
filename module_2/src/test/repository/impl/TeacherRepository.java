package test.repository.impl;

import test.common.ReadAndWrite;
import test.model.Teacher;
import test.repository.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private static final String PATH_TEACHER = "src/test/data/data.csv";
    List<Teacher> stringList = new ArrayList<>();
    @Override
    public List<Teacher> getAllTeacher() {
        List<String> strings = ReadAndWrite.readFile(PATH_TEACHER);
        stringList.clear();
        String[] info;
        for (String s: strings) {
            info = s.split(",");
            stringList.add(new Teacher(info[0],info[1],info[2],info[3]));
        }
        return stringList;
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        stringList = getAllTeacher();
        stringList.remove(teacher);
        List<String> strings = new ArrayList<>();
        for (Teacher temp: stringList) {
            strings.add(temp.getCode()+","+temp.getName()+","+temp.getDate()+","+temp.getDress());
        }
        ReadAndWrite.writeFile(PATH_TEACHER,strings,false);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        List<String> strings =new ArrayList<>();
        strings.add(teacher.getCode()+","+teacher.getName()+","+teacher.getDate()+","+teacher.getDress() );
        ReadAndWrite.writeFile(PATH_TEACHER,strings,true);
    }

    @Override
    public Teacher getByCOde(String code) {
        stringList = getAllTeacher();
        for (Teacher teacher: stringList) {
            if (teacher.getCode().equals(code)){
                return teacher;
            }
        }
        return null;
    }
}
