package com.manager.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO = new StudentDAO();

    public void init() {
        studentDAO = new StudentDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateStudent(request,response);
                break;
            case "sort":
                sortStudent(request,response);
                break;
            case "search":
                showSearch(request,response);
                break;
            case "edit":
                try {
                    showEditStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    showDeleteStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    listStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("search");
        List<Student> studentList = studentDAO.searchStudent(keyword);
        request.setAttribute("searchStudent",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/search.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student>studentList = studentDAO.sortStudent();
        request.setAttribute("sortStudent",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/sort.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> student = studentDAO.selectStudentAll();
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudentDAO(id);
        List<Student>studentList = studentDAO.selectStudentAll();
        request.setAttribute("student",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        requestDispatcher.forward(request,response);
    }



    private void showEditStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.selectStudentDAO(id);
        request.setAttribute("students",student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    insertStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateStudent(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            case "login":
                loginStudent(request,response);
                break;
        }
    }

    private void loginStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if("admin".equals(username) && "admin".equals(password)) {
            writer.println("<h1>Welcome "+username+" to website</h1>");
        } else{
            writer.println("<h1>Login Error</h1>");
        }
        writer.println("</html>");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request,response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(id,name,gender,email,phone,age);
        studentDAO.updateStudentDAO(student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(name,gender,email,phone,age);
        studentDAO.insertStudentDAO(student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(request,response);
    }
}
