package com.example.furama.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameType;
    @JsonBackReference
    @OneToMany(mappedBy = "type")
    private Set<Customer> customerSet;


    public Type() {
    }

    public Type(int id, String nameType, Set<Customer> customerSet) {
        this.id = id;
        this.nameType = nameType;
        this.customerSet = customerSet;
    }


}
