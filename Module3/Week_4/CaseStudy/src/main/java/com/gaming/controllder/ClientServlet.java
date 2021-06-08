package com.gaming.controllder;

import com.gaming.DAO.ClientDAO;
import com.gaming.model.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/clients")
public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO;
    public void init() {
        clientDAO = new ClientDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "view":
                    showView(request,response);
                case "create":
                    showClient(request, response);
                case "edit":
                    showEditClient(request, response);
                    break;
                case "delete":
                    deleteClient(request, response);
                    break;
                case "list-with-machine":
                    showClientWithMachine(request,response);
                    break;
                default:
                    listClient(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("idClient"));
        Client client = clientDAO.select(id);
        RequestDispatcher requestDispatcher;
            request.setAttribute("client",client);
            requestDispatcher = request.getRequestDispatcher("client/view.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
//    private void showViewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if(customer == null){
//            dispatcher = request.getRequestDispatcher("Eros-404");
//        }else{
//            request.setAttribute("customer",customer);
//            dispatcher = request.getRequestDispatcher("customer/view.jsp");
//        }
//        dispatcher.forward(request,response);
//    }


    private void showClientWithMachine(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/list_with_machine.jsp");
        List<Client> clientList = clientDAO.listWithMachine();
        request.setAttribute("clientList", clientList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("idClient"));
        clientDAO.delete(id);
        List<Client>clientList = clientDAO.selectAll();
        request.setAttribute("clientList",clientList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditClient(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("idClient"));
        Client client = clientDAO.select(id);
        request.setAttribute("client",client);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listClient(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Client>clientList = clientDAO.selectAll();
        request.setAttribute("clientList",clientList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showClient(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/create.jsp");
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
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertClient(request, response);
                    break;
                case "edit":
                    updateClient(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        String nameClient = request.getParameter("nameClient");
        String nameMachine = request.getParameter("nameMachine");
        String nameProduct = request.getParameter("nameProduct");
        int accountProduct = Integer.parseInt(request.getParameter("accountProduct"));
        int accountTime = Integer.parseInt(request.getParameter("accountTime"));
        float totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
        Client client = new Client(idClient,nameClient,nameMachine,nameProduct,accountProduct,accountTime,totalMoney);
        clientDAO.update(client);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String nameClient = request.getParameter("nameClient");
        Client client = new Client(nameClient);
        clientDAO.insert(client);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("client/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}