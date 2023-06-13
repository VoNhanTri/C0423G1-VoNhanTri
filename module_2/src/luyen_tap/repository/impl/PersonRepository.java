package luyen_tap.repository.impl;

import luyen_tap.common.WriteAndRead;
import luyen_tap.model.Person;
import luyen_tap.repository.IPersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonRepository implements IPersonRepository {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PATH_PERSON = "src/luyen_tap/data/data.csv";
    private static List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getAllPerson() {
        List<String> strings = WriteAndRead.readFile(PATH_PERSON);
        personList.clear();
        String[] info;
        for (String s : strings) {
            info = s.split(",");
            personList.add(new Person(info[0], info[1], info[2]));
        }
        return personList;
    }

    @Override
    public void deletePerson(Person person) {
        personList = getAllPerson();
        personList.remove(person);
        List<String> strings = new ArrayList<>();
        for (Person temp : personList) {
            strings.add(temp.getCode() + "," + temp.getName() + "," + temp.getDate());
        }
        WriteAndRead.writeFile(PATH_PERSON, strings, false);
    }

    @Override
    public void addPerson(Person person) {
        List<String> strings = new ArrayList<>();
        strings.add(person.getCode() + "," + person.getName() + "," + person.getDate());
        WriteAndRead.writeFile(PATH_PERSON,strings, true);
    }

    @Override
    public Person getBYCode(String code) {
        personList = getAllPerson();
        for (Person person: personList) {
            if (person.getCode().equals(code)){
                return person;
            }
        }
        return null;
    }
}
