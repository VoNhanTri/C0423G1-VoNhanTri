package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll(String name);

    void save(Blog blog);

    Blog findById(int id);

    void edit(int id, Blog blog);

    void delete(int id);
}
