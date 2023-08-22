package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name like :name", nativeQuery = true)
    List<Blog> searchName(@Param(value = "name") String name, Pageable pageable);

    Page<Blog> findBlogByNameContaining(Pageable pageable, String name);

    @Query(value = " insert into blog(content,name,title,category_id) values(:content,:name,:title,:category_id)",nativeQuery = true)
    void saveBlog(@Param(value = "content") String content, @Param(value = "name") String name, @Param(value = "title") String title, @Param(value = "category_id") int categoryId);

    @Query(value = "select * from blog where id=:id ",nativeQuery = true)
    Blog findByIdBlog(@Param(value = "id") int id);

    @Query(value = "update blog set content= :content, name= :name, title= :title, catrgory_id= :catelogy where id=:id",nativeQuery = true)
    void editBlog(@Param(value = "content") String content, @Param(value = "name") String name, @Param(value = "title") String title, @Param(value = "category_id") int category,@Param(value = "id") int id);
@Query(value = "delete from blog where id= :id",nativeQuery = true)
    void deleteBlog(@Param(value = "id") int id);


}
