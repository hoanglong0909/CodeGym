package com.controller;

import com.model.Category;
import com.DAO.DAO;
import com.model.Electronic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
            List<Electronic> listp = dao.selectAll();
            request.setAttribute("listp",listp);
            //phần chia category
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
        request.setCharacterEncoding("UTF-8");
    }
}
