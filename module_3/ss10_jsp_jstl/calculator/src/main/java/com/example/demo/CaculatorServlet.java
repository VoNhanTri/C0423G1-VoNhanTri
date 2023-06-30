package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CaculatorServlet", value = "/CaculatorServlet")
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstNum = Double.parseDouble(request.getParameter("firstNum"));
        double secondNum = Double.parseDouble(request.getParameter("secondNum"));
        String choose = request.getParameter("choose");
        double result = 0;
        switch (choose){
            case "total":
                result = firstNum+secondNum;
                break;
            case "sub":
                result = firstNum-secondNum;
                break;
            case "core":
                result= firstNum*secondNum;
                break;
            case "div":
                result = firstNum/secondNum;
                break;
            default:
                System.out.println("nhap lai");
        }
        request.setAttribute("result1", result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/caculator.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
