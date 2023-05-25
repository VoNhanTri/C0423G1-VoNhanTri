package bai_tap_them.repository.impl;

import bai_tap_them.model.Person;
import bai_tap_them.model.impl.Student;
import bai_tap_them.model.impl.Teacher;
import bai_tap_them.repository.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements IPersonRepository {
    private static List<Person> teacherList = new ArrayList<>();

    static {
        teacherList.add(new Teacher("101", "Lê Thị Hồng", "12/05/1980", "Nữ", "10"));
        teacherList.add(new Teacher("102", "Tô Hiệu", "02/05/1980", "Nam", "10"));
        teacherList.add(new Teacher("103", "Lan Anh", "12/05/1980", "Nữ", "10"));
    }

    @Override
    public List<Student> getAll() {
        return teacherList;
    }

    @Override
    public void addPerson(Person person) {
        teacherList.add((Teacher) person);
    }

    @Override
    public void removePerson(Person person) {
        teacherList.remove((Teacher) person);
    }

    @Override
    public Person getByID(String id) {
        for (Person teacher: teacherList) {
            if (teacher.getId().equals(id));
            return teacher;
        }
        return null;
    }
}
