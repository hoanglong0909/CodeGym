package com.account.controller;

import com.account.model.Account;
import com.account.service.AccountDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AccountServlet", value = "/login")
public class AccountServlet extends HttpServlet {
    AccountDAO accountDAO;
    public void init(){
        accountDAO = new AccountDAO();
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
    // chờ anh tìm kiếm tí đã, lỗi mà không hiện lỗi ra thì chịu :))
    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = accountDAO.accounts(username,password);
        if(account == null){
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            request.setAttribute("message", "you have successfully added new !");
            try {
                rd.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("body/home.jsp");
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
