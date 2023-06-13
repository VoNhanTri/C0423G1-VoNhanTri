package test.model;

import java.util.Objects;

public class Teacher {
    private String code;
    private String name;
    private  String date;
    private String dress;

    public Teacher() {
    }

    public Teacher(String code, String name, String date, String dress) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.dress = dress;
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

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(code, teacher.code) && Objects.equals(name, teacher.name) && Objects.equals(date, teacher.date) && Objects.equals(dress, teacher.dress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, date, dress);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", dress='" + dress + '\'' +
                '}';
    }
}
