package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name like :name", nativeQuery = true)
    Page<Blog> searchName(@Param(value = "name") String name, Pageable pageable);

    Page<Blog> findBlogByNameContaining(Pageable pageable, String name);

    @Modifying
    @Transactional
    @Query(value = " insert into blog(name,title,content,category_id) values(:name,:title,:content,:category_id)", nativeQuery = true)
    void saveBlog(@Param(value = "name") String name, @Param(value = "title") String title,@Param(value = "content") String content,  @Param(value = "category_id") int categoryId);

    @Query(value = "select * from blog where id=:id ", nativeQuery = true)
    Blog findByIdBlog(@Param(value = "id") int id);

    @Modifying
    @Transactional
    @Query(value = "update blog set name= :name, title= :title,content= :content,  category_id= :category where id=:id", nativeQuery = true)
    void editBlog(@Param(value = "name") String name, @Param(value = "title") String title,@Param(value = "content") String content, @Param(value = "category") int category, @Param(value = "id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from blog where id= :id", nativeQuery = true)
    void deleteBlog(@Param(value = "id") int id);


}
