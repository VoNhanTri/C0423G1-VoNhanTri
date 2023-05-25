package bai_tap_them.service.impl;

import bai_tap_them.model.Person;
import bai_tap_them.model.impl.Student;
import bai_tap_them.repository.IPersonRepository;
import bai_tap_them.repository.impl.StudentRepository;
import bai_tap_them.service.IPersonService;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IPersonService {
private static Scanner scanner = new Scanner(System.in);
private static IPersonRepository studentRepository = new StudentRepository();
    @Override
    public void disPlayAll() {
        List<Student> students = studentRepository.getAll();
        for (Person person: students) {
            System.out.println(person);
        }
    }
    @Override
    public void addPerson() {

    }

    @Override
    public void deletePerson() {

    }
}
