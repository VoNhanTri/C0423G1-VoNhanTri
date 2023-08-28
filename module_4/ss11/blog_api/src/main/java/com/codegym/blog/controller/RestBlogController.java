package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class RestBlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll() {
        List<Blog> blogPage = iBlogService.findAllAPI();
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Blog blog) {
        iBlogService.save(blog);
        return new ResponseEntity<>("them moi thanh cong", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Blog blog){
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.edit(id,blog);
        return  new ResponseEntity<>("update thanh cong", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id,@RequestBody Blog blog){
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.delete(id);
        return new ResponseEntity<>("xoa thanh cong", HttpStatus.OK);
    }
}
