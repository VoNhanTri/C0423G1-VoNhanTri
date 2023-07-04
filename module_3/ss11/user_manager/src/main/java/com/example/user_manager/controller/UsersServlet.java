package com.example.user_manager.controller;

import com.example.user_manager.model.Users;
import com.example.user_manager.service.IUsersService;
import com.example.user_manager.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersServlet", value = "/UsersServlet")
public class UsersServlet extends HttpServlet {
    private IUsersService usersService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "find":
                showFind(request,response);
                break;
            case "findCountry":
                showFindCountry(request,response);
                break;
            default:
                showList(request,response);
                break;
                
                        
        }
    }

    private void showFindCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
       List<Users> users = usersService.findCountry(country);
       RequestDispatcher requestDispatcher;
       if (users==null){
           requestDispatcher = request.getRequestDispatcher("/error.jsp");
       }else {
           request.setAttribute("users",users);
           requestDispatcher = request.getRequestDispatcher("find_country.jsp");
           try {
               requestDispatcher.forward(request,response);
           } catch (ServletException e) {
               throw new RuntimeException(e);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Users> usersList = usersService.display();
        String mess =  request.getParameter("mess");
        request.setAttribute("mess",mess);
        request.setAttribute("usersList", usersList);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFind(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/add.jsp");

            requestDispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
    switch (action){
        case "create":
            create(request,response);
            break;
        case "findCountry":
            findCountry(request,response);
            break;
    }
    }

    private void findCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<Users> users = usersService.findCountry(country);
        RequestDispatcher requestDispatcher;
        if (users==null){
            requestDispatcher = request.getRequestDispatcher("/error.jsp");

        }else {
            usersService.findCountry("country");
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String country = request.getParameter("country");
    Users users = new Users(id,name,email,country);
    usersService.add(users);
        try {
            response.sendRedirect("/UsersServlet?mess=them%20moi");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
