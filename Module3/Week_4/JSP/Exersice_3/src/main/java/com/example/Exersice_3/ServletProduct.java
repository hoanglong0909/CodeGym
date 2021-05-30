package com.example.Exersice_3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProduct", value = "/ServletProduct")
public class ServletProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float amount = Float.parseFloat(request.getParameter("amount"));
        float price = Float.parseFloat(request.getParameter("price"));
        String product =  request.getParameter("product");

        float total = price * amount ;
        PrintWriter writer = response.getWriter();
        request.setAttribute("product",product);
        request.setAttribute("amount",amount);
        request.setAttribute("price",price);
        request.setAttribute("total",total);
//        writer.println("<html>");
//        writer.println("<h1>Product: " + product+ "</h1>");
//        writer.println("<h1>Amount: " + amount+ "</h1>");
//        writer.println("<h1>Price: " + price+ "</h1>");
//        writer.println("<h1>Prices : " + prices+ "</h1>");
//        writer.println("</html>");

        RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
        rd.forward(request,response);
    }
}
