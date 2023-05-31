package bai_tap_them.repository.impl;

import bai_tap_them.common.ReadAndWrite;
import bai_tap_them.model.impl.Student;
import bai_tap_them.repository.IStudentRepository;
import bai_tap_them.repository.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;

public  class StudentRepository implements IStudentRepository {
    private static List<Student> studentsList = new ArrayList<>();
    private static final String PATH_STUDENT = "src/bai_tap_them/data/student.csv";
    @Override
    public List<Student> getAllStudent() {
        List<String>  strings = ReadAndWrite.readFile(PATH_STUDENT);
        studentsList.clear();
        String[] info;
        for (String s:strings) {
            info = s.split(",");
            studentsList.add(new Student(info[0],info[1],info[2],info[3],info[4],Float.parseFloat(info[5])));
        }
        return studentsList;
    }

    @Override
    public void addStudent(Student student) {
        List<String> strings = new ArrayList<>();
        strings.add(student.getId()+","+student.getName()+","+student.getDate()+","+student.getGender()+","+student.getClasses()+","+student.getPoint());
        ReadAndWrite.writeFile(PATH_STUDENT,strings,true);
    }

    @Override
    public void removeStudent(Student student) {
        studentsList = getAllStudent();
        studentsList.remove(student);
        List<String> strings = new ArrayList<>();
        for (Student temp: studentsList){
            strings.add(temp.getId()+","+temp.getName()+","+temp.getDate()+","+temp.getGender()+","+temp.getClasses()+","+temp.getPoint());
        }
        ReadAndWrite.writeFile(PATH_STUDENT,strings,false);

    }

    @Override
    public Student getByIDStudent(String id) {
        studentsList = getAllStudent();
        for (Student student: studentsList) {
            if (student.getId().equals(id));
            return student;
        }
        return null;
    }
}
