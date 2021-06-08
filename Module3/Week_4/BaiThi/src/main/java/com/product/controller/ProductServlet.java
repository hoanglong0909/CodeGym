package com.product.controller;

import com.product.dao.CategoryDAO;
import com.product.model.Category;
import com.product.model.Product;
import com.product.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO = new CategoryDAO();

    public void init() {
        productDAO = new ProductDAO();
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
                    showAddProductPage(request, response);
                case "edit":
                    showEditProduct(request, response);
                    break;
                case "search":
                    searchProduct(request,response);
                case "delete":
                    deleteCProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String keyword = request.getParameter("search");
        List<Product> productList = productDAO.searchProduct(keyword);
        request.setAttribute("productList",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/search.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void deleteCProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        List<Product> productList = productDAO.selectAll();
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectOne(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Product> productLists = productDAO.selectAll();
        request.setAttribute("productList", productLists);
        System.out.println(productLists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }


    private void showAddProductPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.selectAll();
        request.setAttribute("categories", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int idCategory = Integer.parseInt(request.getParameter("category"));
        Category category = categoryDAO.selectOne(idCategory);
        Product product = new Product(id, productName, price, quantity, color,category);
        productDAO.update(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String nameProduct = request.getParameter("nameProduct");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int idCategory = Integer.parseInt(request.getParameter("category"));
        System.out.println(idCategory);
        Category category = categoryDAO.selectOne(idCategory);
        Product product = new Product( nameProduct, price, quantity, color, category);
        System.out.println(product);
        productDAO.insert(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






