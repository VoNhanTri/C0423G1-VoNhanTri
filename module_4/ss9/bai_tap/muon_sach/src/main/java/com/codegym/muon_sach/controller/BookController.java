package com.codegym.muon_sach.controller;

import com.codegym.muon_sach.dto.BorrowDto;
import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.BorrowDetail;
import com.codegym.muon_sach.model.Customer;
import com.codegym.muon_sach.service.IBookService;
import com.codegym.muon_sach.service.IBorrowService;
import com.codegym.muon_sach.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowService iBorrowService;
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "",required = false)String name, Model model,
                           @RequestParam(defaultValue = "0",required = false)int page){
        Pageable pageable = PageRequest.of(page,2, Sort.by("id").ascending());
        Page<Book> bookPage = iBookService.findAll(pageable,name);
        model.addAttribute("bookPage",bookPage);
        model.addAttribute("name",name);
        return "list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model){
        List<Customer> customerList = iCustomerService.findCustomer();
        model.addAttribute("customerList",customerList);
        Book book = iBookService.findById(id);
        String code = book.generateRandomCode();
        model.addAttribute("book",book);
        model.addAttribute("code",code);
        return "detail";
    }
    @PostMapping("/detail")
    public String borrow(@ModelAttribute int code, BorrowDto borrowDto,BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new BorrowDto().validate(borrowDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "detail";
        }
        BorrowDetail borrowDetail = new BorrowDetail();
        iBorrowService.save(code,borrowDetail);
        redirectAttributes.addFlashAttribute("mess","thanh cong");
        return ("redirect:/book");
    }
}
