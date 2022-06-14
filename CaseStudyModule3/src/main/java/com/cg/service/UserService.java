package com.cg.service;

import com.cg.Utils.MySQLUtils;
import com.cg.model.Role;
import com.cg.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IOUserService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/module3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0379825939";


    private static final String VIEW_USER_SQL = "SELECT us.id,us.name,us.email,us.password,us.phone,us.address,us.city,role.role FROM user us JOIN role on us.role = role.id WHERE us.deleted = '0'ORDER BY us.id desc ;";
    private static final String VIEWS_USER_SQL = "SELECT us.id,us.name,us.email,us.password,us.phone,us.address,us.city,role.role FROM user us JOIN role on us.role = role.id WHERE us.deleted = '0'ORDER BY us.id desc ;";
    private static final String INSERT_USER_SQL ="INSERT INTO user (name,email,password,phone,address,city,role) VALUE(?,?,?,?,?,?,?);";
    private static final String ACCOUNT_USER_SQL ="SELECT us.id,us.name,us.email,us.phone,role.role FROM user us JOIN role on us.role = role.id where name= ? and email = ? and password = ? AND us.deleted = '0';";
    private static final String BY_ID_USER_SQL = "SELECT us.id,us.name,us.email,us.password,us.phone,us.address,city,role.role FROM user us JOIN role on us.role = role.id WHERE us.id = ?;";
    private static final String UPDATE_USER_SQL = "UPDATE user SET name = ? , email = ? , password = ?, phone = ?, address = ?, city = ? ,role = ? WHERE id = ?;";
    private static final String DELETE_USER_SQL = "UPDATE user us SET us.deleted = '1' WHERE us.id = ?;";
    private static final String UNLOCK_USER_SQL = "SELECT us.id,us.name,us.email,us.password,us.phone,us.address,us.city,role.role FROM user us JOIN role on us.role = role.id WHERE us.deleted = '1'ORDER BY us.id desc ;";
    private static final String MO_UNLOCK_SQL ="UPDATE user us SET us.deleted = '0' WHERE us.id = ?;";
    private static final String SEARCH_USER_SQL = "SELECT us.id,us.name,us.email,us.phone,us.address,us.city,us.role FROM user us \n" +
            "WHERE us.name LIKE ? OR us.email LIKE ? OR us.phone LIKE ? OR us.address LIKE ? OR us.city LIKE ? ;";



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


    public List<User> SelectUser() {
       List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_USER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password =rs.getString("password");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String role = rs.getString("role");
                userList.add(new User(id,name,email,password,phone,address,city,role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    public List<User> SelectUser_Delete() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(VIEWS_USER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password =rs.getString("password");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String role = rs.getString("role");
                userList.add(new User(id,name,email,password,phone,address,city,role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Boolean AddUser(User user) {
        boolean inserted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getPhone());
            preparedStatement.setString(5,user.getAddress());
            preparedStatement.setString(6,user.getCity());
            preparedStatement.setString(7,user.getRole());
            preparedStatement.executeUpdate();
            inserted = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inserted;
    }
    public void AddMenu(){

    }

    @Override
    public User ShowUser(int id) {
        User user = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BY_ID_USER_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String role = resultSet.getString("role");
                user = new User(id,name,email,password, phone, address,city,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean EditUser(User user) {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5,user.getAddress());
            preparedStatement.setString(6,user.getCity());
            preparedStatement.setString(7,user.getRole());
            preparedStatement.setInt(8, user.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public User checkloginuser(String name,String email, String password) {
        User user ;
        try  {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT_USER_SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                name = rs.getString(2);
                email=rs.getString(3);
                password=rs.getString(4);
                String role = rs.getString(5);
            user = new User(name,email,password,role);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<User> SELEUNLOCK() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UNLOCK_USER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password =rs.getString("password");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String role = rs.getString("role");
                userList.add(new User(id,name,email,password,phone,address,city,role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    public boolean UNLOCK(int id) {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MO_UNLOCK_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    public List<User> SEARCH(String name, String email, String phone,String address,String city) {

            List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_SQL);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + email+ "%");
            preparedStatement.setString(3,"%" + phone + "%");
            preparedStatement.setString(4,"%" + address + "%");
            preparedStatement.setString(5,"%" + city + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                 name = rs.getString("name");
                 email = rs.getString("email");
                 phone = rs.getString("phone");
                 address = rs.getString("address");
                 city = rs.getString("city");
                  String  role = rs.getString("role");
                userList.add(new User(id,name,email,phone,address,city,role));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
