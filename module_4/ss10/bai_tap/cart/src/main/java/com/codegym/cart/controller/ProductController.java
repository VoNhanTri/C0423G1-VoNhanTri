package com.codegym.cart.controller;

import com.codegym.cart.dto.CartDto;
import com.codegym.cart.dto.ProductDto;
import com.codegym.cart.model.Product;
import com.codegym.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
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
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showListPage(Model model, @SessionAttribute(value = "cart", required = false) CartDto cartDto,
                               @CookieValue(value = "productId", required = false,
                                       defaultValue = "-1") Long id) {
        model.addAttribute("historyProduct", iProductService.findById(id));
        if (cartDto != null) {
            model.addAttribute("cart", cartDto);
        }
        model.addAttribute("productList", iProductService.findAll());
        return "/product/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable long id, HttpServletResponse response, Model model) {
        //tao cookie de luu lich su xem san pham gan nhat
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", iProductService.findById(id));
        return "/product/detail";
    }

    // them moi vao gio hang
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute(value = "cart") CartDto cartDto) {
        Product product = iProductService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
