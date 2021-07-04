package com.product.controller;

import com.product.DAO.DAO;
import com.product.model.Category;
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

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    DAO dao;
    public void init() {
        dao = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("id");
        try {
            List<Electronic> list = dao.getProductCid(Integer.parseInt(categoryId));
            List<Category> categoryList = dao.selectCategoriesAll();
            request.setAttribute("electronicList",list);
            request.setAttribute("categoryList",categoryList);
            request.setAttribute("tag",categoryId);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("body/home.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
