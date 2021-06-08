package com.manager.service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }switch (action){
            case "create":
                showCreate(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case  "delete":
                try {
                    showDelete(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                searchUser(request,response);
                break;
            default:
                ShowList(request,response);
                break;
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("search");
        List<User>userList = new ArrayList<>();
        userDAO.searchUser(keyword);
        request.setAttribute("search",userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/search.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowList(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userDAO.selectUserALL();
        request.setAttribute("userList",userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        List<User> userList = userDAO.selectUserALL();
        request.setAttribute("userList",userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User newUser = userDAO.selectUser(id);
        request.setAttribute("newUser",newUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }switch (action){
            case "insert":
                insertUser(request,response);
            case "update":
                try {
                    updateUser(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        User user = new User(id,userName,passWord);
        userDAO.updateUser(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
            requestDispatcher.forward(request,response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        User newUser = new User(userName,passWord);
        userDAO.insertUser(newUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
            requestDispatcher.forward(request,response);
    }

}
