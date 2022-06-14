package com.cg.controller;

import com.cg.Utils.Validate;
import com.cg.model.Customer;
import com.cg.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addmenu")
public class AddMenuServlet extends HttpServlet {




    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/AddCustomer.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int color = 1;
        String message;
        String Drinks = request.getParameter("Drinks");
        Long Price = Long.valueOf(request.getParameter("Price"));
        String image = request.getParameter("image");
        Customer customer = new Customer(Drinks,image,Price);
        request.setAttribute("color", color);
        message = "You Added Success";
        request.setAttribute("message", message);
        customerService.AddMenu(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/AddCustomer.jsp");
        dispatcher.forward(request, response);
    }
}
