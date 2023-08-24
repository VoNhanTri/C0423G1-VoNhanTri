package com.codegym.muon_sach.controller;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.BorrowDetail;
import com.codegym.muon_sach.service.IBookService;
import com.codegym.muon_sach.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowService iBorrowService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "",required = false)String name, Model model,
                           @RequestParam(defaultValue = "0",required = false)int page){
        Pageable pageable = PageRequest.of(page,2, Sort.by("id").ascending());
        Page<Book> bookPage = iBookService.findAll(pageable,name);
        model.addAttribute("bookPage",bookPage);
        model.addAttribute("name",name);
        return "list";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam int id,Model model){
        Book book = iBookService.findById(id);
        model.addAttribute("book",book);
        return "detail";
    }
    @PostMapping("/borrow")
    public String borrow(@ModelAttribute BorrowDetail borrowDetail, RedirectAttributes redirectAttributes){
        iBorrowService.save(borrowDetail);
        redirectAttributes.addFlashAttribute("mess","muon thanh cong");
        return ("redirect:/book");
    }
}
