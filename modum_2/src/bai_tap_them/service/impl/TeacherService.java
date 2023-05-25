package bai_tap_them.service.impl;

import bai_tap_them.model.Person;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    public static void disPlayAllTeacher(){
        List<Person> teacher = new ArrayList<>();
        for (Person person: teacher){
            System.out.println(person);
        }
    }
}
