package luyen_tap.repository;

import luyen_tap.model.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAllPerson();
    void deletePerson(Person person);
    void addPerson(Person person);
    Person getBYCode(String code);
}
