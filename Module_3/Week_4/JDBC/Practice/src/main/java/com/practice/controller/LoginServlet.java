package com.practice.controller;

import com.practice.dao.UserDAO;
import com.practice.model.Account;
import com.practice.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    public void init() {
        userDAO = new UserDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            loginUser(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = userDAO.accounts(username,password);
        if(account == null){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("message", "you have successfully added new !");
            try {
                rd.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            List<User> listUser = userDAO.selectAllUsers();
            request.setAttribute("listUser", listUser);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            try {
                rd.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
