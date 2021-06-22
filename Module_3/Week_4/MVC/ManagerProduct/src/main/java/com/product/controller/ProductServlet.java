package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import com.product.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateProduct(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                CreateProduct(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void CreateProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        float price = Float.parseFloat("price");
        String describe = request.getParameter("describe");
        String producer = request.getParameter("producer");
        int id = (int)(Math.random()*1000) ;
        Product product = new Product(id,name,price,describe,producer);
        this.productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }
}
