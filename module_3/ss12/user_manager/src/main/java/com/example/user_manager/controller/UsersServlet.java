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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "findCountry":
                showFindCountry(request, response);
                break;
            default:
                showList(request, response);
                break;


        }
    }

    private void showFindCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/find_country.jsp");
        requestDispatcher.forward(request, response);

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Users> usersList = usersService.display();
        String mess = request.getParameter("mess");
        request.setAttribute("mess", mess);
        request.setAttribute("usersList", usersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = usersService.findById(id);
        request.setAttribute("id",id);
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/edit.jsp");

        requestDispatcher.forward(request, response);
    }


    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = usersService.findById(id);
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/delete.jsp");
        requestDispatcher.forward(request, response);

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/add.jsp");

        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "findCountry":
                findCountry(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Users users = new Users(name, email, country);
       usersService.edit(id,users);
        response.sendRedirect("/UsersServlet");


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        usersService.delete(id);
        response.sendRedirect("/UsersServlet");

    }

    private void findCountry(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String country = request.getParameter("country");
        List<Users> usersList = usersService.findCountry(country);
        request.setAttribute("usersList", usersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("find_country.jsp");
        requestDispatcher.forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
//    int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Users users = new Users(name, email, country);
        usersService.add(users);
        try {
            response.sendRedirect("/UsersServlet?mess=them%20moi");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
