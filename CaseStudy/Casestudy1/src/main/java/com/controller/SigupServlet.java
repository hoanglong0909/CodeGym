package com.controller;

import com.model.Login;
import com.DAO.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SigupServlet", value = "/signup")
public class SigupServlet extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        String password_2 = request.getParameter("passWord_2");
        RequestDispatcher requestDispatcher;
        if(!password.equals(password_2)){
            request.setAttribute("mess","Mật khẩu không khớp vui lòng đăng kí lại !");
            requestDispatcher = request.getRequestDispatcher("account/login.jsp");
            requestDispatcher.forward(request,response);
        }else {
            Login login = dao.acountCheckExist(userName);
            if(login == null){
                try {
                    dao.signup(userName,password,email);
                    request.setAttribute("mess_1","bạn đã đăng kí thành công hãy đăng nhâp");
                    requestDispatcher = request.getRequestDispatcher("account/login.jsp");
                    requestDispatcher.forward(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else{
                request.setAttribute("mess","Tên đăng nhập đã tồn tại vui lòng đăng kí lại !");
                requestDispatcher = request.getRequestDispatcher("account/login.jsp");
                requestDispatcher.forward(request,response);
            }
        }
    }
}
