package bai_test.repository.impl;

import bai_test.comon.ReadAndWrite;
import bai_test.model.Student;
import bai_test.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    private static final String PATH_STUDENT = "src/bai_test/data/student.csv";

    @Override
    public void deleteStudent(Student student) {
        studentList = getAllStudent();
        studentList.remove(student);
        List<String> strings = new ArrayList<>();
        for (Student temp : studentList) {
            strings.add(temp.getCode() + "," + temp.getName() + "," + temp.getDate() + "," + temp.getClasses());
        }
        ReadAndWrite.writeFile(strings, PATH_STUDENT, false);
    }

    @Override
    public void addStudent(Student student) {
        List<String> strings = new ArrayList<>();
        strings.add(student.getCode() + "," + student.getName() + "," + student.getDate() + "," + student.getClasses());
        ReadAndWrite.writeFile(strings, PATH_STUDENT, true);
    }

    @Override
    public List<Student> getAllStudent() {
        List<String> students = ReadAndWrite.readFile(PATH_STUDENT);
        studentList.clear();
        String[] info;
        for (String s : students) {
            info = s.split(",");
            studentList.add(new Student(info[0], info[1], info[2], info[3]));
        }
        return studentList;
    }

    @Override
    public Student getByCode(String code) {
        studentList = getAllStudent();
        for (Student student: studentList) {
            if (student.getCode().equals(code)){
                return student;
            }
        }
        return null;
    }
}
