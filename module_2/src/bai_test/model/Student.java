package bai_test.model;

import java.util.Objects;

public class Student {
    private String code;
    private String name;
    private String date;
    private String classes;

    public Student(String code, String name, String date, String classes) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.classes = classes;
    }

    public Student() {
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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(code, student.code) && Objects.equals(name, student.name) && Objects.equals(date, student.date) && Objects.equals(classes, student.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, date, classes);
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
