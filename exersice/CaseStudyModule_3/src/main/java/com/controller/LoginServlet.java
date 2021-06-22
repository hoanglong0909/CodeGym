package com.controller;

import com.DAO.UserDAO;
import com.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/logins")
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

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, SQLException {
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
            RequestDispatcher rd = request.getRequestDispatcher("login/list.jsp");
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

