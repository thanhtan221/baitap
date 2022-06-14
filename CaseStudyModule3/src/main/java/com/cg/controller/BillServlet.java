package com.cg.controller;

import com.cg.model.Bill;
import com.cg.model.Customer;
import com.cg.service.BillService;
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

@WebServlet(value = "/bill")
public class BillServlet extends HttpServlet {
    BillService billService = new BillService();
    CustomerService customerService = new CustomerService();
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
                case "listbill":
                    ListBill(request,response);

                default:
                    ListBill(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

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


                default:
                    ListBill(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void ListBill(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        List<Bill> billList =billService.SELECTBILL();
        request.setAttribute("billList", billList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bill/Bill.jsp");
        dispatcher.forward(request, response);
    }

}
