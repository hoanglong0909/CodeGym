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

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    DAO dao;
    public void init(){
        dao = new DAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Login login = dao.account(userName,passWord);
        RequestDispatcher requestDispatcher;
        if(login == null){
            request.setAttribute("mess","bạn đã nhập sai vui lòng nhập lại !");
            requestDispatcher = request.getRequestDispatcher("account/login.jsp");
            requestDispatcher.forward(request,response);
        }else {
            HttpSession session = request.getSession();
            try {
                List<Electronic> electronicList = dao.selectAll();
                List<Category> categoryList = dao.selectCategoriesAll();
                request.setAttribute("electronicList",electronicList);
                request.setAttribute("categoryList",categoryList);

                session.setAttribute("account",login);
                session.setMaxInactiveInterval(100);
                requestDispatcher = request.getRequestDispatcher("body/home.jsp");
                requestDispatcher.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }
}
