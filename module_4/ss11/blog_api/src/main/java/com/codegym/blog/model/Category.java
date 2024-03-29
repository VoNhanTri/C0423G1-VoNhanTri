package com.codegym.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCategory;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogSet;

    public Category() {
    }

    public Category(int id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
