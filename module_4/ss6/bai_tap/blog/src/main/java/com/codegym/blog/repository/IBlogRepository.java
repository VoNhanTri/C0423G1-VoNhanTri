package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name like :name", nativeQuery = true)
    List<Blog> searchName(@Param(value = "name") String name);
}
