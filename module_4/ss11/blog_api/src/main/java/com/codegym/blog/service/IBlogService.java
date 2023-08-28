package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable, String name);

    void save(Blog blog);

    Blog findById(int id);

    void edit(int id, Blog blog);

    void delete(int id);

    List<Blog> findAllAPI();
}
