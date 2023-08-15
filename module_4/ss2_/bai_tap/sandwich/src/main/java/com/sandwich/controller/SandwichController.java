package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home")
public class SandwichController {
    @GetMapping("")
    public String check(){
        return "spice";
    }
    @PostMapping("/save")
    public String save(@RequestParam(name = "checkbox",required = false,defaultValue = "To Check") String[] checkbox, RedirectAttributes redirectAttributes){
//        List<String> list = new ArrayList<>();
//        for (String che: checkbox) {
//            list.add(che);
//        }

        redirectAttributes.addFlashAttribute("checkbox", Arrays.toString(checkbox));
        return "redirect:/home";
    }
}
