package com.product.controller;

import com.product.DAO.DAO;
import com.product.model.Category;
import com.product.model.Electronic;
import com.product.model.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ManagerStaffServlet", value = "/staff")
public class ManagerStaffServlet extends HttpServlet {
    DAO dao = new DAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute("account");
        int id = login.getId();
        try {
            List<Electronic> electronicList = dao.selectAll();
            request.setAttribute("productAll", electronicList);
//            List<Electronic> electronicList = dao.getProductBySellId(id);
            List<Category> categoryList = dao.selectCategoriesAll();
            request.setAttribute("elist",electronicList);
            request.setAttribute("categoryList",categoryList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/list.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
