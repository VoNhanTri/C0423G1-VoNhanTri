package bai_tap_them.model.impl;

import bai_tap_them.model.Person;

import java.util.Objects;

public class Student extends Person {
    private String classes;
    private float point;

    public Student(String id, String name, String date, String gender, String classes, float point) {
        super(id, name, date, gender);
        this.classes = classes;
        this.point = point;
    }

    public Student() {
    }

    public Student(String classes, float point) {
        this.classes = classes;
        this.point = point;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Float.compare(student.point, point) == 0 && Objects.equals(classes, student.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classes, point);
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "classes='" + classes + '\'' +
                ", point=" + point +
                '}';
    }
}
