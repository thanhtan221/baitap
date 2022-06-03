package controller;

import service.CustomersServece;
import model.Customers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/customers")
public class customersServlet extends HttpServlet {
    CustomersServece customersDAO = new CustomersServece();

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "AddCustomers":
                    ShowCustomers(request, response);
                    break;
                case "EditCustomers":
                    ShowEdit(request, response);
                    break;
                case "DepositCustomers":
                    ShowDeposit(request, response);
                    break;
                case "Transfer":
                    ShowTransfer(request,response);
                    break;
                case"delete":
                    ShowDelete(request,response);
                    break;
                case"withdraw":
                    ShowWithdraw(request,response);
                    break;
                default:
                    customers(request, response);
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
                case "AddCustomers":
                    AddCustomers(request, response);
                    break;
                case "EditCustomers":
                    EditCustomers(request, response);
                    break;
                case "DepositCustomers":
                    DepositCustomers(request, response);
                    break;
                case "Transfer":
                    Transfer(request,response);
                    break;
                case"delete":
                    Delete(request,response);
                    break;
                case"withdraw":
                    WithdrawCustomers(request,response);
                default:
                    customers(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }


    private void ShowCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/add.jsp");
        dispatcher.forward(request, response);
    }

    private void customers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, SQLException, ServletException {
        List<Customers> customersList = customersDAO.SelectUser();
        request.setAttribute("customersList", customersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public boolean AddCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, SQLException, ServletException {
        String full_name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Customers customers = new Customers(full_name, email, phone, address);
        boolean inserted = customersDAO.AddCustomers(customers);
        if (full_name != null && email != null) {
            request.setAttribute("successful", "Thêm Thành Công");
        } else {
            request.setAttribute("successfulss", "Vui Lòng Nhập Tên Đầy Đủ");
            request.setAttribute("successfuls", "Vui Lòng Nhập Gmail Đầy Đủ");
        }
        if (inserted) {
            request.setAttribute("successful", "Thêm Thành Công");

        } else {
            request.setAttribute("error", null);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/add.jsp");
        dispatcher.forward(request, response);
        return inserted;
    }

    public void ShowEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customers customers = customersDAO.ShowCustomers(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/edit.jsp");
        request.setAttribute("Customers", customers);
        dispatcher.forward(request, response);

    }

    private void EditCustomers(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String full_name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Customers customers = new Customers(id, full_name, email, phone, address);
        customersDAO.EditCustomers(customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void DepositCustomers(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Long Amount = Long.valueOf(request.getParameter("Amount"));
        Customers customers = new Customers(id, Amount);
        customersDAO.DepositCustomers(customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/deposit.jsp");
        dispatcher.forward(request, response);
    }

    public void ShowDeposit(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customers customers = customersDAO.ShowDeposit(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/deposit.jsp");
        request.setAttribute("Customers", customers);
        dispatcher.forward(request, response);

    }
    private void WithdrawCustomers(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Long transactionAmount = Long.valueOf(request.getParameter("transactionAmount"));
        Customers customers = new Customers(id, transactionAmount);
        customersDAO.WithdrawCustomers(customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/withdraw.jsp");
        dispatcher.forward(request, response);
    }
    public void ShowWithdraw(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customers customers = customersDAO.ShowDeposit(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/withdraw.jsp");
        request.setAttribute("Customers", customers);
        dispatcher.forward(request, response);

    }

    public void Transfer(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int ids = Integer.parseInt(request.getParameter("RecipientId"));
        Long transferAmount = Long.valueOf(request.getParameter("transferAmount"));
        Customers customers = new Customers(id,ids,transferAmount);
            customersDAO.Transfer(customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/transfer.jsp");
        dispatcher.forward(request, response);

    }

    public void ShowTransfer(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customers customers = customersDAO.ShowTransfer(id);
        List<Customers> customersList = customersDAO.SelectUser();
        request.setAttribute("customersList", customersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/transfer.jsp");
        request.setAttribute("Customers", customers);
        dispatcher.forward(request, response);

    }
    public void Delete(HttpServletRequest request,HttpServletResponse response) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        customersDAO.deleteCustomers(id);
        List<Customers> customersList =customersDAO.SelectUser();
        request.setAttribute("Customers",customersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
    public void ShowDelete(HttpServletRequest request,HttpServletResponse response) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        Customers customers = customersDAO.ShowCustomers(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customers/delete.jsp");
        request.setAttribute("Customers", customers);
        dispatcher.forward(request, response);

    }
}