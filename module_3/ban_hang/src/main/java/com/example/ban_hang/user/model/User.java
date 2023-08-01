package com.example.ban_hang.user.model;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private Date createDate;
    private String status;
    private int role_id;

    public User() {
    }

    public User(int id, String username, String password,String email ,Date createDate, String status, int role_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
        this.status = status;
        this.role_id = role_id;
    }

    public User(String username, String password,String email, Date createDate, String status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
        this.status = status;
    }

    public User(String newUser, String newPass) {
        this.username = newUser;
        this.password = newPass;

    }

    public User(int id, String newUser, String newPass) {
        this.id = id;
        this.username = newUser;
        this.password = newPass;
    }

    public User(String newUser, String newPass, String newEmail) {
        this.username = newUser;
        this.password = newPass;
        this.email = newEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
