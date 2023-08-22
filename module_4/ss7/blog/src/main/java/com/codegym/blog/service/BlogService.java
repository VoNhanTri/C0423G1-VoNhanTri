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
        iBlogRepository.saveBlog(blog.getName(), blog.getTitle(), blog.getContent(), blog.getCategory().getId());
    }
//
    @Override
    public Blog findById(int id) {
        return iBlogRepository.findByIdBlog(id);
    }

    @Override
    public void edit(int id, Blog blog) {
        iBlogRepository.editBlog(blog.getName(), blog.getTitle(), blog.getContent(), blog.getId(), blog.getCategory().getId());
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteBlog(id);
    }

}
