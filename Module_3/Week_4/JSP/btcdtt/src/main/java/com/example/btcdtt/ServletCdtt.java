package com.example.btcdtt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletCdtt", value = "/convert")
public class ServletCdtt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        float rate = Float.parseFloat(getInitParameter("rate"));
        float usd = Float.parseFloat(getInitParameter("usd"));

        float vnd = rate * usd ;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
