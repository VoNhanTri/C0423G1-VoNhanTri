package bai_tap_them.repository.impl;

import bai_tap_them.model.Person;
import bai_tap_them.model.impl.Student;
import bai_tap_them.repository.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IPersonRepository {
    private static List<Student> studentsList = new ArrayList<>();
    static {
        studentsList.add(new Student("001","Võ Nhân Trí","24/09/2012","Nam","C3323",10));
        studentsList.add(new Student("002","Trần Thị Bê","12/12/2012","Nữ","C3323",9));
        studentsList.add(new Student("003","Nguyễn Văn A","02/01/2012","Nam","C3323",8));
    }
    @Override
    public List<Student> getAll() {
        return studentsList;
    }

    @Override
    public void addPerson(Person person) {
        studentsList.add((Student) person);
    }

    @Override
    public void removePerson(Person person) {
        studentsList.remove((Student) person);
    }

    @Override
    public Person getByID(String id) {
        for (Student student: studentsList) {
            if (student.getId().equals(id));
            return student;
        }
        return null;
    }
}
