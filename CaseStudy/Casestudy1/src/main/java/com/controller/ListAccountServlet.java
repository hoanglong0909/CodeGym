package com.controller;

import com.DAO.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ListAccountServlet", value = "/totalaccount")
public class ListAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = new DAO();
        int count = 0;
        try {
            count = dao.getTotalAccount();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        double endPage = Math.ceil(count/5) ;

        System.out.println(count);
        request.setAttribute("endP",endPage);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/listall.jsp");
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

    }
}
