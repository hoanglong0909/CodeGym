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

@WebServlet(name = "ElectronicServlet", value = "/electronics")
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
                case "search":
                    showSearch(request, response);
                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
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
        }
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

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
//                case "create":
//                    insertUser(request, response);
//                    break;
//                case "edit":
//                    updateUser(request, response);
//                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


//
//private void listUser(HttpServletRequest request, HttpServletResponse response)
//        throws SQLException, IOException, ServletException {
//        List<User> listUser = userDAO.selectAllUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
//        }
//
//
//private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
//        }
//
////    private void sortUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        List <User> sortUser = userDAO.sortByName();
////        request.setAttribute("sortUser",sortUser);
////        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/sort.jsp");
////        requestDispatcher.forward(request,response);
////    }
////
//
//private void showSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        String keyword = request.getParameter("search");
//        List<User> userList = userDAO.searchUsers(keyword);
//        request.setAttribute("userList",userList);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/search.jsp");
//        requestDispatcher.forward(request,response);
//        }
//
//private void insertUser(HttpServletRequest request, HttpServletResponse response)
//        throws SQLException, IOException, ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(name, email, country);
//        userDAO.insertUser(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        request.setAttribute("message", "you have successfully added new !");
//        dispatcher.forward(request, response);
//        }
//
//private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//        throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userDAO.selectUser(id);
//        request.setAttribute("users", existingUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
//
//        dispatcher.forward(request, response);
//        }
//
//private void updateUser(HttpServletRequest request, HttpServletResponse response)
//        throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User book = new User(id, name, email, country);
//        userDAO.updateUser(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
//        dispatcher.forward(request, response);
//        }
//
//private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//        throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        userDAO.deleteUser(id);
//        List<User> listUser = userDAO.selectAllUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
//        }

