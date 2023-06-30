package com.example.hien_thi.model;

public class Customer {
    private int id;
    private String name;
    private String date;
    private String dress;
    private String image;

    public Customer() {
    }

    public Customer(int id, String name, String date, String dress, String image) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.dress = dress;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
