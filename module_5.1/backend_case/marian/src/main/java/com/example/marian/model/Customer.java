package com.example.marian.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String gender;
    private String identity;
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "type_Id", referencedColumnName = "id")
    private TypeCustomer typeCustomer;

    public Customer() {
    }

    public Customer(int id, String name, String date, String gender, String identity, String phone, String email, String address, TypeCustomer typeCustomer) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.identity = identity;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.typeCustomer = typeCustomer;
    }
}



