package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String name, Model model) {
        List<Blog> blogList = iBlogService.findAll(name);
        model.addAttribute("blogList", blogList);
        model.addAttribute("name", name);
        return "list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Them Moi Thanh Cong");
        return ("redirect:/blog");
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blogs", blog);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, int id, RedirectAttributes redirectAttributes) {
        iBlogService.edit(id, blog);
        redirectAttributes.addFlashAttribute("mess", "sua thanh cong");
        return ("redirect:/blog");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "xoa thanh cong");
        return "redirect:/blog";
    }
}
