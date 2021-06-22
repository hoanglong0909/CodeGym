package com.example.JstlDemo3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diep
 */
public class ServletStudent extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("R001", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new Student("R002", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new Student("R003", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new Student("R004", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new Student("R005", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));

        request.setAttribute("studentList", studentList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/lession5/studentList.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
