package com.codegym.hom_thu_dien_tu.controller;

import com.codegym.hom_thu_dien_tu.model.MailBox;
import com.codegym.hom_thu_dien_tu.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/home")
public class MailBoxController {
    @Autowired
    private IMailBoxService mailBoxService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<MailBox> mailBoxList = mailBoxService.findAll();
        model.addAttribute("mailBoxList", mailBoxList);
        return "list";
    }


    @GetMapping("/mail")
    public String showAdd(Model model) {
        model.addAttribute("mailBox", new MailBox());
        return "mail";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        MailBox mailBox = mailBoxService.findById(id);
        model.addAttribute("mailBox", mailBox);
        return "detail";
    }

    @PostMapping("/detail")
    public String edit(@ModelAttribute MailBox mailBox, int id, RedirectAttributes redirectAttributes) {
        mailBoxService.edit(id, mailBox);
        redirectAttributes.addFlashAttribute("mess", "sua thanh cong");
        return "redirect:/home/list";
    }

    @PostMapping("/mail")
    public String add(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes) {
        mailBoxService.add(mailBox);
        redirectAttributes.addFlashAttribute("mess", "them mo0i thanh cong");
        return "redirect:/home/list";
    }
}
