package bai_tap_them.repository;

import bai_tap_them.model.Person;
import bai_tap_them.model.impl.Student;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAll();
    void addPerson(Person person);
    void removePerson(Person person);
    Person getByID(String id);

}
