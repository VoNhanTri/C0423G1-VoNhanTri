package com.example.ban_hang.product.controller;

import com.example.ban_hang.product.model.Product;
import com.example.ban_hang.product.service.IProductService;
import com.example.ban_hang.product.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showAdd":
                showAdd(request, response);
                break;
            case "showItem":
                showItem(request, response);
                break;
            default:
                showDisplay(request, response);
                break;
        }
    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/add.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showItem(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showDisplay(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.display();
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/display.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                add(request, response);
                break;
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        int price = Integer.parseInt(request.getParameter("price"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        String description = request.getParameter("description");
        int productType = Integer.parseInt(request.getParameter("productType"));
        Product product = new Product(code, name, image, price, inventory, description, productType);
        productService.add(product);
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
