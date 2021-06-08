package com.product.controller;

import com.product.DAO.DAO;
import com.product.model.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    DAO dao;
    public void init(){
        dao = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Login login = dao.account(userName,passWord);

        if(login ==null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/login.jsp");
            requestDispatcher.forward(request,response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("body/home.jsp");
            requestDispatcher.forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
