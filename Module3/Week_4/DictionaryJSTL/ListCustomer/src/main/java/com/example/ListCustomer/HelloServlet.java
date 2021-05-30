package com.example.ListCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       List<Customer> customers = new ArrayList<>();
       customers.add(new Customer("Mai văn hoàng","2/2/1999","Hanoi","<>"));
       customers.add(new Customer("Trong Nguyen","2/2/1999","Hanoi","long.jpg"));
       customers.add(new Customer("Mai văn hoàng","2/2/1999","Hanoi","long.jpg"));
       customers.add(new Customer("Mai văn hoàng","2/2/1999","Hanoi","long.jpg"));
       customers.add(new Customer("Mai văn hoàng","2/2/1999","Hanoi","long.jpg"));

       request.setAttribute("customers",customers);
       RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
       dispatcher.forward(request,response);

//        RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
//        rd.forward(request,response);
    }

    public void destroy() {
    }
}