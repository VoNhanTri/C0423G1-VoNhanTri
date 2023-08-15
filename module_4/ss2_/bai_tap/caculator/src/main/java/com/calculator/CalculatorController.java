package com.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class CalculatorController {
    @GetMapping("")
    public String display() {
        return "index";
    }

    @PostMapping("/index")
    public String calculator(@RequestParam("calculator") String calculator, @RequestParam(name = "numberOne",required = false,defaultValue = "0") Double numberOne, @RequestParam(name = "numberTwo",required = false,defaultValue = "0") Double numberTwo, RedirectAttributes redirectAttributes) {
        double result = 0;

        if (calculator.equals("addition")) {
            result = (numberOne + numberTwo);
        } else if (calculator.equals("subtraction")) {
            result = (numberOne - numberTwo);
        } else if (calculator.equals("multiplication")) {
            result = (numberOne * numberTwo);
        } else if (calculator.equals("division")) {
            result = (numberOne / numberTwo);
        }
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/home";
    }
}
