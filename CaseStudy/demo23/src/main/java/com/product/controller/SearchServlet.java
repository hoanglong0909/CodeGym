package com.product.controller;

import com.product.DAO.DAO;
import com.product.model.Electronic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    DAO dao;
    public void init() {
        dao = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String search = request.getParameter("searchList");
        try {
            List<Electronic> electronicList = dao.searchElectronic(search);
            request.setAttribute("electronicList",electronicList);
            request.setAttribute("txtS",search);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("body/home.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
