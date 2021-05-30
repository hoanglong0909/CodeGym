package com.practice.controller;

import com.practice.model.Customer;
import com.practice.service.CustomerService;
import com.practice.service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }switch (action){
            case "create":
                showCreateCustomer(request,response);
                break;
            case "edit":
                showEditCustomer(request,response);
                break;
            case "delete":
                showDeleteCustomer(request,response);
                break;
            case "view":
                showViewCustomer(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void showViewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("Eros-404");
        }else{
            request.setAttribute("customer",customer);
            dispatcher = request.getRequestDispatcher("customer/view.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void showDeleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null) {
            dispatcher = request.getRequestDispatcher("Eroos-404");
        }else {
            request.setAttribute("customer",customer);
            dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher ;
        if(customer ==null){
            dispatcher = request.getRequestDispatcher("Error-404");
        }else {
            request.setAttribute("customer",customer);
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            requestDispatcher.forward(request,response);
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
            action ="";
        }switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                updataCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher ;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("Eros-404");
        }else {
            this.customerService.remove(id);
        }
        response.sendRedirect("/customer");
    }

    private void updataCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher ;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("Error-404");
        }else {

             customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            this.customerService.update(id,customer);
            request.setAttribute("customer",customer);
            request.setAttribute("message","Customer information was updated");
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int)(Math.random()*1000);
        Customer customer = new Customer(id,name,email,address);
        this.customerService.save(customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message","New customer was created");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customer",customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
