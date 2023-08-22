package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    public Page<Blog> findAll(Pageable pageable,String name) {
        return iBlogRepository.findBlogByNameContaining(pageable,name);
    }

    @Override
    public void save(Blog blog) {
        String name = blog.getName();
        String title = blog.getTitle();
        String content = blog.getContent();
        int categoryId = blog.getId();
        iBlogRepository.saveBlog(name,title,content,categoryId);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findByIdBlog(id);
    }

    @Override
    public void edit(int id, Blog blog) {
        String name = blog.getName();
        String title = blog.getTitle();
        String content = blog.getContent();
        int category = blog.getCategory().getId();
        iBlogRepository.editBlog(name,title,content,category,blog.getId());
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteBlog(id);
    }

}
