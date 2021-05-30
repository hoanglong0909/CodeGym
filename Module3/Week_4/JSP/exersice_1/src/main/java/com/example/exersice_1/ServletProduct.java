package com.example.exersice_1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProduct", value = "/ServletProduct")
public class ServletProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        double discountAmount = Double.parseDouble(price) * Double.parseDouble(discount) * 0.01D;
        double discountPrice = Double.parseDouble(price) - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h2>Discount Amount: " + Double.toString(discountAmount) + "</h2>");
        writer.println("<h2>Discount Price: " + Double.toString(discountPrice) + "</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
