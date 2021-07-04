package com.cart;

import com.DAO.DAO;
import com.model.Category;
import com.model.Electronic;
import com.model.Item;
import com.model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddtoCartServlet", value = "/addToCart")
public class AddtoCartServlet extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = 1;
        int id;
        String categoryId = request.getParameter("id");
        try {
            List<Electronic> electronicList = dao.selectAll();
            List<Category> categoryList = dao.selectCategoriesAll();
            request.setAttribute("electronicList", electronicList);
            request.setAttribute("categoryList",categoryList);
            //phần chia category
            List<Electronic> list = dao.getProductCid(Integer.parseInt(categoryId));
            request.setAttribute("electronicList", list);
            request.setAttribute("tag", categoryId);
        }catch (Exception e){
            System.out.println(e);
        }
        if (request.getParameter("pId") != null) {
            id = Integer.parseInt(request.getParameter("pId"));
            Electronic electronic = null;
            try {
                electronic = dao.getProductById(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (electronic != null) {
                if (request.getParameter("quantity") != null) {
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                }
                HttpSession session = request.getSession();
                if (session.getAttribute("order") == null) {
                    Order order = new Order();
                    List<Item> itemList = new ArrayList<>();
                    Item item = new Item();
                    item.setQuantity(quantity);
                    item.setElectronic(electronic);
                    item.setPrice(electronic.getPrice());
                    itemList.add(item);
                    order.setItems(itemList);
                    session.setAttribute("order", order);
                } else {
                    Order order = (Order) session.getAttribute("order");
                    List<Item> itemList = order.getItems();
                    boolean check = false;
                    for (Item item : itemList) {
                        if (item.getElectronic().getId() == electronic.getId()) {
                            item.setQuantity(item.getQuantity() + quantity);
                            check = true;
                        }
                    }
                    if (check == false) {
                        Item item = new Item();
                        item.setElectronic(electronic);
                        item.setQuantity(quantity);
                        item.setPrice(electronic.getPrice());
                        itemList.add(item);
                    }
//                    Float total = Float.valueOf(0);
//                    for (Item o: itemList
//                    ) {
//                        total = total + o.getQuantity() * o.getPrice();
//                    }
//                    request.setAttribute("total", total);
//                    request.setAttribute("vat", 0.1 * total);
//                    request.setAttribute("sum", 1.1 * total);
                    session.setAttribute("order", order);
                }
            }

        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("body/home.jsp");
            requestDispatcher.forward(request,response);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("body/home.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
