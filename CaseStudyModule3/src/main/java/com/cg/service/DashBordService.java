package com.cg.service;

import com.cg.model.Customer;
import com.cg.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DashBordService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0379825939";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }



    private static final String TOTALUSER_SQL = "SELECT COUNT(id) as totaluser FROM user WHERE deleted ='0';";
    private static final String TOTALSALES_SQL = "SELECT COUNT(ct.id) as totalsales FROM cart ct;";

    public List<User> SELECTTotal() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(TOTALUSER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long totaluser = rs.getLong("totaluser");
                userList.add(new User(totaluser));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

}
