package luyen_tap.model;

import java.util.Objects;

public class Person {
    private String code;
    private  String name;
    private String date;

    public Person() {
    }

    public Person(String code, String name, String date) {
        this.code = code;
        this.name = name;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(code, person.code) && Objects.equals(name, person.name) && Objects.equals(date, person.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, date);
    }

    @Override
    public String toString() {
        return "Person{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
