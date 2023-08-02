package com.example.ban_hang.product.controller;

import com.example.ban_hang.product.dto.ProductListDto;
import com.example.ban_hang.product.model.Product;
import com.example.ban_hang.product.model.ProductType;
import com.example.ban_hang.product.service.IProductService;
import com.example.ban_hang.product.service.IProductTypeService;
import com.example.ban_hang.product.service.ProductService;
import com.example.ban_hang.product.service.ProductTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();
    private static IProductTypeService productTypeService = new ProductTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                    List<ProductType> typeList = productTypeService.getAllP();
                    request.setAttribute("typeList",typeList);
                    request.getRequestDispatcher("/product/add.jsp").forward(request,response);
                break;
            default:
                List<ProductListDto> productListDto = productService.getAllDto();
                if (productListDto.size() == 0) {
                    request.setAttribute("productListDto", null);
                } else {
                    request.setAttribute("productListDto", productListDto);
                }
                request.getRequestDispatcher("/product/display.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                String code = request.getParameter("code");
                String name= request.getParameter("name");
                int price = Integer.parseInt(request.getParameter("price"));
                int inventory = Integer.parseInt(request.getParameter("inventory"));
                String description = request.getParameter("description");
                String nameType = request.getParameter("nameType");
                String urlImage = request.getParameter("urlImage");
                ProductListDto product = new ProductListDto(code,name,price,inventory,description, nameType,urlImage);
                productService.add(product);
                response.sendRedirect("/ProductServlet");
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                productService.delete(id);
                response.sendRedirect("/ProductServlet");
        }
    }
}
