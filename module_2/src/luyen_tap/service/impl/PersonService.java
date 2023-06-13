package luyen_tap.service.impl;


import luyen_tap.model.Person;
import luyen_tap.repository.IPersonRepository;
import luyen_tap.repository.impl.PersonRepository;
import luyen_tap.service.IPersonService;

import java.util.List;
import java.util.Scanner;

public class PersonService implements IPersonService {
    private static Scanner scanner = new Scanner(System.in);

    private static IPersonRepository personService = new PersonRepository();
    @Override
    public void  displayAll() {
        List<Person> personList = personService.getAllPerson();
        for (Person person: personList) {
            System.out.println(person);
        }
    }

    @Override
    public void delete() {
        System.out.println("moi ban nhap ma muon xoa");
        String code = scanner.nextLine();
        Person person = personService.getBYCode(code);
        if (person==null){
            System.out.println("ma ko dung");
        }else {
            System.out.println("ban co muon xopa san pham co ten "+person.getName());
            System.out.println("1. xoa");
            System.out.println("2. khong xoa");
        }
        String choice = scanner.nextLine();
        if (choice.equals("1")){
            personService.deletePerson(person);
            System.out.println("xoa thanh cong");
        }

    }

    @Override
    public void add() {
        System.out.println("nhap ma san pham");
        String code = scanner.nextLine();
        System.out.println("nhap ten san pham");
        String name = scanner.nextLine();
        System.out.println("nhap ngay san xuat");
        String date = scanner.nextLine();
        Person person = new Person(code,name,date);
        personService.addPerson(person);
    }
}
