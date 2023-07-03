package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.service.IProductService;
import com.example.quan_ly_san_pham.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action==null){
        action="";
    }
    switch (action){
        case "create":
            showCreateForm(request,response);
            break;
        case "delete":
            showDelete(request,response);
            break;
        default:
            showList(request,response);
    }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = this.productService.findById(id);
    RequestDispatcher requestDispatcher;
    if(product == null){
        requestDispatcher= request.getRequestDispatcher("/error-404.jsp");
    }else {
        request.setAttribute("product",product);
        requestDispatcher = request.getRequestDispatcher("/delete.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.display();
        String mess =  request.getParameter("mess");
        request.setAttribute("mess",mess);
        request.setAttribute("productList",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/add.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create" :
                create(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = productService.findById(id);
    RequestDispatcher requestDispatcher;
    if (product==null){
        requestDispatcher = request.getRequestDispatcher("error-404.jsp");
    }else {
        productService.delete(product);
        try {
            response.sendRedirect("/ProductServlet?mess=xoa%20roi%20");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String status = request.getParameter("status");
        String producer = request.getParameter("producer");
        Product product=new Product(id,name,price,status,producer);
        System.out.println(product.getId());
        productService.add(product);
        try {
            response.sendRedirect("/ProductServlet?mess=them%20moi%20");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
