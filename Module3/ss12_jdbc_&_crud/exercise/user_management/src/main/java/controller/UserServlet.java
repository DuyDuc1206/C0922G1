package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/home")
public class UserServlet extends HttpServlet {
    IUserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                save(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;
            case "search":
                searchUser(request,response);
                break;
            default:
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User> userList = this.userService.selectUserByCountry(country);
        request.setAttribute("userList",userList);
        request.setAttribute("countrySave",country);
        try {
            request.getRequestDispatcher("user/search.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userService.updateUser(user);
//        request.setAttribute("user",user);
        try {
            request.getRequestDispatcher("/user/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showlist(request,response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        userService.insertUser(user);
        showlist(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                showInsertForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                showlist(request, response);

        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/user/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showInsertForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/user/insert.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showlist(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.selectAllUser();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
