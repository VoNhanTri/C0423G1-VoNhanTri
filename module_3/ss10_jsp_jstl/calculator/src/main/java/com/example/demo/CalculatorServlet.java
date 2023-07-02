package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstNum = Double.parseDouble(request.getParameter("firstNum"));
        double secondNum = Double.parseDouble(request.getParameter("secondNum"));
        String choose = request.getParameter("choose");
        double result = 0;
        switch (choose){
            case "+":
                result = firstNum+secondNum;
                break;
            case "-":
                result = firstNum-secondNum;
                break;
            case "*":
                result= firstNum*secondNum;
                break;
            case "/":
                result = firstNum/secondNum;
                break;
            default:
                System.out.println("nhap lai");
                break;
        }
        request.setAttribute("result1", result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Calculator.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
