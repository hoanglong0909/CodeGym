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

@WebServlet(name = "DetailServlet", value = "/detail")
public class DetailServlet extends HttpServlet {
    DAO dao;
    public void init(){
        dao = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("pid"));

        try {
            Electronic electronic = dao.getProductById(id);
            List<Electronic> elist = dao.getProductBySellId(id);
            List<Category> categoryList = dao.selectCategoriesAll();

            List<Electronic> electronicList = dao.selectAll();

            request.setAttribute("elist",electronicList);

            request.setAttribute("categoryList",categoryList);
            request.setAttribute("electronicList",elist);
            request.setAttribute("detail",electronic);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("body/product.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}