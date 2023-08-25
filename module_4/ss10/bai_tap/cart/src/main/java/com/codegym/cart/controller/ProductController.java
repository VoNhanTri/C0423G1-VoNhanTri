package com.codegym.cart.controller;

import com.codegym.cart.dto.CartDto;
import com.codegym.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    public CartDto initCart(){
        return new CartDto();
    }
    @Autowired
   private IProductService iProductService;
    @GetMapping("")
    public String showListPage(Model model, @SessionAttribute(value = "cart",required = false)CartDto cartDto,
                               @CookieValue(value = "productId",required = false,
                               defaultValue = "-1") Long id){
        model.addAttribute("historyProduct",iProductService.findById(id));
        if (cartDto!=null){
            model.addAttribute("cart",cartDto);
        }
        model.addAttribute("productList",iProductService.findAll());
        return "list";
    }
    @GetMapping("/detail")
    public String detail(@PathVariable long id, HttpServletResponse response,Model model){
        Cookie cookie = new Cookie("productId", id+"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", iProductService.findById(id));
        return "detail";
    }
}
