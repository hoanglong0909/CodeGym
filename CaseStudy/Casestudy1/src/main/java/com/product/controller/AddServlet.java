package com.product.controller;

import com.product.DAO.DAO;
import com.product.model.Category;
import com.product.model.Electronic;
import com.product.model.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        Float price = Float.valueOf(request.getParameter("price"));
        int category = Integer.parseInt(request.getParameter("category"));
//        HttpSession session = request.getSession();
//        Login login = (Login) session.getAttribute("account");
//        int sell_id = login.getId();
        int sell_id = Integer.parseInt(request.getParameter("sell_id"));
        try {
            Electronic electronic = new Electronic(name, image, price, category, sell_id);
            dao.insertProduct(electronic);
            request.setAttribute("electronic", electronic);
            request.setAttribute("mess","Bạn đã thêm thành công sản phẩm !");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
