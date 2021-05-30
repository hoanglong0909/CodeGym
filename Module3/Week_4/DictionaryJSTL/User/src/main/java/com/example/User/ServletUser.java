package com.example.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "ServletUser", value = "")
public class ServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        try {
            request.setAttribute("user",dao.dummyData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/display-user.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
