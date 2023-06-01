package bai_tap_them.model.impl;

import bai_tap_them.model.Person;

import java.util.Objects;

public class Teacher extends Person {
    private String specialize;
    public Teacher(String id, String name, String date, String gender, String specialize) {
        super(id, name, date, gender);
        this.specialize = specialize;
    }
    public Teacher(String specialize) {
        this.specialize = specialize;
    }

    public Teacher() {
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(specialize, teacher.specialize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialize);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString()+
                "specialize='" + specialize + '\'' +
                '}';
    }
}
