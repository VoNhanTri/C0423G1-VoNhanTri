package com.codegym.quan_ly.controller;

import com.codegym.quan_ly.model.Product;
import com.codegym.quan_ly.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("publishers")
    public String[] getProducer() {
        return new String[]{"Orion", "Pham Nguyen", "Biscafun", "Lotte"};
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Them moi thanh cong");
        return ("redirect:/home/list");
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "edit";

    }
    @PostMapping("/edit")
    public String Edit(@ModelAttribute Product product,int id ,RedirectAttributes redirectAttributes){
        productService.update(id,product);
        redirectAttributes.addFlashAttribute("mess","edit thanh cong");
        return "redirect:/home/list";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam int id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }
    @PostMapping ("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("mess","xoa thanh cong");
        return "redirect:/home/list";
    }
    @PostMapping ("/find")
    public String find(@RequestParam String name,Model model){
        List<Product> product = productService.findByName(name);
        model.addAttribute("productList",product);
        return "find";
    }
}
