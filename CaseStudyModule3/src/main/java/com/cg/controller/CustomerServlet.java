package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "addCart":
                    addCart(request,response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "menucustomer":
                    MenuCustome(request, response);
                    break;
                case "addCart":
                    addCart(request,response);
                    break;

                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }



    public void MenuCustome(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Customer> customerList = customerService.SelectMenu();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/MenuCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        List<Customer> customerList = customerService.SelectMenu();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/ListCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void addCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {
        int oder_id = Integer.parseInt(request.getParameter("id"));
        Customer customer = new Customer(oder_id);
        customerService.AddCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/ListCustomer.jsp");
        dispatcher.forward(request, response);

    }




}
