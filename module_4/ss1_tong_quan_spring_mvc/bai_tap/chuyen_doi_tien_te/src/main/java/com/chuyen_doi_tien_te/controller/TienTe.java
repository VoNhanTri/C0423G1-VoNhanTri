package com.chuyen_doi_tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class TienTe {
    @GetMapping("/greeting/index")
    public String quyDOi() {
        return "index";
    }

    @PostMapping("/greeting/index")
    public String doi(@RequestParam String selectOne, @RequestParam String selectTwo, @RequestParam int nhap, Model model) {
        double bang = 0;
        if (selectOne.equals(selectTwo)) {
            bang = nhap;
        }
        if (selectOne.equals("usd") && selectTwo.equals("vnd")) {
            bang = (nhap * 23000);
        }
        if (selectOne.equals("vnd") && selectTwo.equals("usd")) {
            bang = (nhap / 23000);
        }
        model.addAttribute("bang", bang);
        return "index";
    }
}
