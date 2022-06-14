package com.cg.controller;

import com.cg.model.Customer;
import com.cg.model.User;
import com.cg.service.DashBordService;
import com.cg.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserService userService;

     DashBordService dashBordService = new DashBordService();

    public void init() {
        userService = new UserService();
    }

    @Override
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
                case "adduser":
                    ShowAddUser(request, response);
                    break;
                case "edituser":
                    ShowEdit(request, response);
                    break;
                case"deleteuser":
                    ShowDelete(request,response);
                    break;
                case "seach":
                    search(request,response);
                    break;
                default:
                    listUser(request, response);
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
                case "adduser":
                    AddUser(request, response);
                    break;
                case "edituser":
                    EditUser(request, response);
                    break;
                case "deleteuser":
                    DeleteUser(request,response);
                    break;
                case "seach":
                    search(request,response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }



    private void listUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        List<User> listUser = userService.SelectUser();
        totalusers(request,response);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/user.jsp");
        dispatcher.forward(request, response);
    }

    private void ShowAddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/AddUser.jsp");
        dispatcher.forward(request, response);

    }

    private void ShowEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.ShowUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/EditUser.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);

    }
    private void AddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int color= 1;
        String message ;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String role = request.getParameter("role");
        User user = new User(name, email, password, phone, address, city, role);
        if (name.equals("")&& email.equals("")){
            color = 0;
            request.setAttribute("color", color);
            message = "cannot be left blank";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/AddUser.jsp");
            dispatcher.forward(request, response);
        }else if (role.equals("1") || role.equals("2")){
            if (name != null && email != null) {
                request.setAttribute("color", color);
                message = "You Added Success";
                request.setAttribute("message", message);
                userService.AddUser(user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/AddUser.jsp");
                dispatcher.forward(request, response);
            }
        }else {
            color = 0;
            request.setAttribute("color", color);
            message = "Please Enter Role 1 Or 2";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/AddUser.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void EditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int color = 1;
        String message;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String role = request.getParameter("role");
        User user = new User(id, name, email, password, phone, address, city, role);
          if (role.equals("1") || role.equals("2")){
              if (name != null && email != null)  {
                  request.setAttribute("color", color);
                  message = "You Added Success";
                  request.setAttribute("message", message);
                  userService.EditUser(user);
                  RequestDispatcher dispatcher = request.getRequestDispatcher("user/AddUser.jsp");
                  dispatcher.forward(request, response);
              }
        }else  {
            color = 0;
            request.setAttribute("color", color);
            message = "Please Enter Role 1 Or 2";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/EditUser.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void ShowDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.ShowUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/DeleteUser.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);


    }

    private void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        List<User> userList = userService.SelectUser_Delete();
        request.setAttribute("user", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/user.jsp");
        request.setAttribute("listUser",userList);
        dispatcher.forward(request, response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("name");
        String phone = request.getParameter("name");
        String address = request.getParameter("name");
        String city = request.getParameter("name");
        userService.SEARCH(name,email,phone,address,city);
        List<User> userList =  userService.SEARCH(name,email,phone,address,city);;
        request.setAttribute("listUser",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/user.jsp");
        dispatcher.forward(request, response);

    }
    private void totalusers(HttpServletRequest request,HttpServletResponse response)  {
        List<User> userList = dashBordService.SELECTTotal();
        request.setAttribute("userList", userList);
    }
}

