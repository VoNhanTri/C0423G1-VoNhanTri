package com.codegym.form.controller;

import com.codegym.form.dto.UserDto;
import com.codegym.form.model.User;
import com.codegym.form.service.IUserService;
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

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "",required = false)String name, Model model,
                           @RequestParam(defaultValue = "0",required = false)int page){
        Pageable pageable = PageRequest.of(page,1, Sort.by("name").ascending());
        Page<User> userPage = iUserService.findAll(name,pageable);
        model.addAttribute("userPage",userPage);
        model.addAttribute("name",name);
        return "/list";

    }
    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("userDto", new UserDto());
        return "add";
    }
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute UserDto userDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "add";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.add(user);
        redirectAttributes.addFlashAttribute("mess","Thêm mới Thành Công");
        return "redirect:/user";
    }
}
