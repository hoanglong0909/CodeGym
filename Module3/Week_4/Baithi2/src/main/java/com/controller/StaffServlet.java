package com.controller;

import com.DAO.StaffDAO;
import com.model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/staffs")
public class StaffServlet extends HttpServlet {
    StaffDAO staffDAO;
    public void init(){
        staffDAO = new StaffDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }switch (action){
            case "create":
                createStaff(request,response);
                break;
            case "edit":
                try {
                    editStaff(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteStaff(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                searchStaff(request,response);
                break;
            default:
                try {
                    listStaff(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void listStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Staff> staffList;
        staffList = staffDAO.selectAll();
        request.setAttribute("staffList", staffList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(staffList);
    }

    private void createStaff(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffDAO.select(id);
        request.setAttribute("staff", staff);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffDAO.delete(id);
        List<Staff> staffList = staffDAO.selectAll();
        request.setAttribute("staffList", staffList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchStaff(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("search");
        List<Staff> staffList = staffDAO.searchProduct(keyword);
        request.setAttribute("staffList", staffList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/search.jsp");
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
            action = "";
        }switch (action){
            case "create":
                try {
                    insertProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String groupStaff = request.getParameter("groupStaff");
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phoneNumber");
        String dob = request.getParameter("dob");
        String cmndNumber = request.getParameter("cmndNumber");
        String email = request.getParameter("email");
        Staff staff = new Staff(id,groupStaff,fullName,gender,phoneNumber,dob,cmndNumber,email);
        staffDAO.update(staff);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String groupStaff = request.getParameter("groupStaff");
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phoneNumber");
        String dob = request.getParameter("dob");
        String cmndNumber = request.getParameter("cmndNumber");
        String email = request.getParameter("email");
        Staff staff = new Staff(groupStaff,fullName,gender,phoneNumber,dob,cmndNumber,email);
        staffDAO.insert(staff);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
