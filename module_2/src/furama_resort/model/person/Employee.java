package furama_resort.model.person;

import java.util.Objects;

public class Employee extends Person {
    private String level;
    private String position;
    private float salary;

    public Employee(String code, String name, String date, String gender, String identityCard, String numberPhone, String email, String level, String position, float salary) {
        super(code, name, date, gender, identityCard, numberPhone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String level, String position, float salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Float.compare(employee.salary, salary) == 0 && Objects.equals(level, employee.level) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), level, position, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
