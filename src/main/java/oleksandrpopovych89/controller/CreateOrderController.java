package oleksandrpopovych89.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oleksandrpopovych89.logic.essence.Order;
import oleksandrpopovych89.logic.repo.OrderRepoDB;
import oleksandrpopovych89.logic.repo.OrdersRepoDB;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create-order")
public class CreateOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id;
        try {
            id = OrdersRepoDB.addNewOrder();
            OrderRepoDB.createOrder(id);
        } catch (SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/order-list?id=" + id);
    }
}