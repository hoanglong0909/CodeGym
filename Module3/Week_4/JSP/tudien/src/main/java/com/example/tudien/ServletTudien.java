package com.example.tudien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletTudien",urlPatterns = "/translate")
public class ServletTudien extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String search = request.getParameter("search");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        if (result != null) {
            writer.println("word: " + search +  "</br>") ;
            writer.println("result: " + result);
        }else{
            writer.println("Nót found ");
        }
        writer.println("<html>");

    }
}

