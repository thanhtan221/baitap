package com.cg.controller;


import com.cg.model.User;
import com.cg.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/unlock")
public class unlockServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
            switch (action) {
                case"unlock":
                    ShowDelete(request,response);
                    break;
                default:
                    ListUNLOCK(request, response);
                    break;
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
        switch (action) {
            case "unlock":
                DeleteUser(request,response);
                break;
            default:
                ListUNLOCK(request, response);
                break;
        }
    }
    private void ListUNLOCK(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userService.SELEUNLOCK();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/unlock.jsp");
        dispatcher.forward(request, response);
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
        userService.UNLOCK(id);
        List<User> userList = userService.SELEUNLOCK();
        request.setAttribute("user", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/unlock.jsp");
        request.setAttribute("listUser",userList);
        dispatcher.forward(request, response);
    }
}
