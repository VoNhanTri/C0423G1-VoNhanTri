package com.example.ban_hang.user.controller;

import com.example.ban_hang.user.model.User;
import com.example.ban_hang.user.service.IUserService;
import com.example.ban_hang.user.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private static IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showAccount":
                showAccount(request, response);
                break;
            case "showSignUp":
                showSignUp(request, response);
                break;
            case "logOut":
                showLogout(request, response);
                break;

        }
    }

    private void showLogout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("acc");
        try {
            response.sendRedirect("/index.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showSignUp(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/sign_up.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showAccount(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/account.jsp");
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
            case "account":
                account(request, response);
                break;
            case "signUp":
                signUp(request, response);
                break;

        }
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePass = request.getParameter("rePass");
        String email = request.getParameter("email");
        User user = userService.checkAccount(username);
        if (!password.equals(rePass)) {
            request.getRequestDispatcher("/user/sign_up.jsp");
        } else {
            if (user == null) {
                userService.signUp(username, password, email);
                try {
                    response.sendRedirect("/index.jsp");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    response.sendRedirect("/user/sign_up.jsp");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void account(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.account(username, password);

        if (user == null) {
            try {
                request.setAttribute("mess", "Mat khau khong dung");
                request.getRequestDispatcher("/user/account.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("acc", user);
                response.sendRedirect("/ProductServlet");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
