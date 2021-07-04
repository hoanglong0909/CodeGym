package com.controller;

import com.model.Category;
import com.model.Electronic;
import com.model.Login;
import com.DAO.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ElectronicServlet", urlPatterns = "/electronics")
public class ElectronicServlet extends HttpServlet {
    DAO dao;
    public void init() {
        dao = new DAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "listProduct":
                    listProductAll(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                default:
                    try {
                        listProduct(request, response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Electronic electronic = null;
        try {
            electronic = dao.select(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Electronic> electronicList = dao.getProductBySellId(id);
        List<Category> categoryList = dao.selectCategoriesAll();
        request.setAttribute("elist", electronicList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("electronic",electronic);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        requestDispatcher.forward(request,response);
    }


    private void listProductAll(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Electronic> electronicList = dao.selectAll();
        request.setAttribute("productAll", electronicList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manager/listall.jsp");
        dispatcher.forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Electronic> electronicList = dao.selectAll();
        List<Category> categoryList = dao.selectCategoriesAll();
        request.setAttribute("electronicList", electronicList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("body/home.jsp");
        dispatcher.forward(request, response);
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute("account");
        int id = login.getId();
        try {
            List<Electronic> electronicList = dao.getProductBySellId(id);
            List<Category> categoryList = dao.selectCategoriesAll();
            request.setAttribute("elist", electronicList);
            request.setAttribute("categoryList", categoryList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        Float price = Float.valueOf(request.getParameter("price"));
        int category = Integer.parseInt(request.getParameter("category"));
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute("account");
        int sell_id = login.getId();
//        int sell_id = Integer.parseInt(request.getParameter("sell_id"));
        Electronic electronic = new Electronic(name, image, price, category, sell_id);
        dao.insertProduct(electronic);
        request.setAttribute("electronic", electronic);
        request.setAttribute("mess","Bạn đã thêm thành công sản phẩm !");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request, response);
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        Float price = Float.valueOf(request.getParameter("price"));
        int category = Integer.parseInt(request.getParameter("category"));
//        HttpSession session = request.getSession();
//        Login login = (Login) session.getAttribute("account");
//        int sell_id = login.getId();
        dao.update(name,image,price,category,id);
        List<Electronic> electronicList = dao.getProductBySellId(id);
        List<Category> categoryList = dao.selectCategoriesAll();
        request.setAttribute("elist",electronicList);
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("mess_1","Bạn đã cập nhập thành công !");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}