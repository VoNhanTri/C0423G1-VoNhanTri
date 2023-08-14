package com.tu_dien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TuDienController {
    @GetMapping("/tudien/index")
    public String tuDien() {
        return "index";
    }
@PostMapping("tudien/index")
    public String dich(@RequestParam String nhap, Model model) {
        String dich = null;
        String[] viet = {"tao", "do", "cam"};
        String[] eng = {"apple", "red", "orange"};
        for (int i = 0; i < viet.length; i++) {
            for (int j = 0; j < eng.length; j++) {
                if (nhap.equals(viet[i])) {
                    dich = eng[i];
                } else if (nhap.equals(eng[j])) {
                    dich = viet[j];
                }
            }
        }
        model.addAttribute("dich", dich);
        return "index";
    }
}
