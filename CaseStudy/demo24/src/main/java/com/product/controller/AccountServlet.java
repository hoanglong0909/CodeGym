package com.product.controller;

import com.product.model.Account;
import com.product.DAO.AccountDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AccountServlet", value = "/login1")
public class AccountServlet extends HttpServlet {
//    AccountDAO accountDAO;
//    public void init(){
//        accountDAO = new AccountDAO();
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
//            Account account = accountDAO.accounts(username,password);
//            if(account == null){
//                RequestDispatcher rd = request.getRequestDispatcher("body/home.jsp");
//                request.setAttribute("message", "you have successfully added new !");
//                try {
//                    rd.forward(request,response);
//                } catch (ServletException | IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                RequestDispatcher rd = request.getRequestDispatcher("body/home.jsp");
//                try {
//                    rd.forward(request,response);
//                } catch (ServletException | IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
