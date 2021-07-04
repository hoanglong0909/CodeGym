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

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    DAO dao = new DAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = dao.selectCategoriesAll();
            List<Electronic> electronicList = dao.selectAll();
            request.setAttribute("electronicList",electronicList);
            request.setAttribute("categoryList",categoryList);
            HttpSession session = request.getSession();
            session.removeAttribute("account");
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
