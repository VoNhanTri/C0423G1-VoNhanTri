package com.example.ban_hang.model.employee;

import java.sql.Date;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private String gender;
    private Date birthday;
    private String phone;
    private String email;
    private String address;
    private String status;
    private String image;

    public Employee() {
    }

    public Employee(int id, String name, int salary, String gender, Date birthday, String phone, String email, String address, String status, String image) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.image = image;
    }

    public Employee(String name, int salary, String gender, Date birthday, String phone, String email, String address, String status, String image) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
