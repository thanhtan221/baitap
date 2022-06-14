package com.cg.service;

import com.cg.model.Customer;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements IOUCustomer {

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

    private static final String VIEW_CUSTOMER_SQL = "SELECT ms.id,ms.Drinks,ms.Price,ms.image FROM menucafeshop ms ";
    private static final String VIEW_CART_SQL = "SELECT ct.id,ms.Drinks,ms.Price,ms.image,ct.quantity,(ms.Price * ct.quantity) as cash FROM cart ct JOIN menucafeshop ms ON ms.id=ct.oder_id WHERE deleted = '0';";
    private static final String ODER_CART_SQL = "INSERT INTO cart (oder_id,quantity) VALUE (?,'1');";
    private static final String BY_ID_CUSTOMER_SQL = "SELECT ct.id,ms.Drinks,ms.Price,ms.image FROM menucafeshop ms WHERE ct.id=?;";
    private static final String TOTAL_SQL ="SELECT SUM(ms.Price * ct.quantity) total FROM cart ct JOIN menucafeshop ms ON ms.id=ct.oder_id WHERE ct.deleted = '0';";
    private static final String UPDATE_CART_SQL = "UPDATE cart SET quantity = ? WHERE id = ?;" ;
    private static final String BY_ID_CART_SQL = "SELECT ct.id,ms.Drinks,ms.Price,ms.image,ct.quantity,(ms.Price * ct.quantity) as cash FROM cart ct JOIN menucafeshop ms ON ms.id=ct.oder_id WHERE ct.id = ?;";
    private static final String DELETE_CART_SQL = "UPDATE cart ct SET ct.deleted = '1' WHERE ct.id = ?;";
    private static final String ADd_MENU_SQL = "INSERT INTO menucafeshop (Drinks,Price,image) VALUE (?,?,?);";


    @Override
    public List<Customer> SelectMenu() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_CUSTOMER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String drinks = rs.getString("Drinks");
                long price = rs.getInt("Price");
                String image = rs.getString("image");
                customers.add(new Customer(id,drinks,image,price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public List<Customer> SeleCart() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_CART_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String drinks = rs.getString("Drinks");
                String image = rs.getString("image");
                long price = rs.getInt("Price");
                long quantity =rs.getInt("quantity");
                long cash = rs.getInt("cash");
                customers.add(new Customer(id,drinks,image,price,quantity,cash));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
    public List<Customer> SELECTTotal() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(TOTAL_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long total = rs.getLong("total");
                customers.add(new Customer(total));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


    @Override
    public void AddCustomer(Customer customer) throws SQLException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ODER_CART_SQL);
            preparedStatement.setInt(1, customer.getOder_id());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddMenu(Customer customer){
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADd_MENU_SQL);
            preparedStatement.setString(1,customer.getDrinks());
            preparedStatement.setLong(2,customer.getPrice());
            preparedStatement.setString(3,customer.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer Showcustmer(int id) {
        Customer customer = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BY_ID_CUSTOMER_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String drinks = rs.getString("Drinks");
                long price = rs.getLong("Price");
                String image =rs.getString("image");
             customer = new Customer(id,drinks,image,price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    public Customer ShowEdit(int id){
        Customer customer = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BY_ID_CART_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                 id = rs.getInt("id");
                String drinks = rs.getString("Drinks");
                String image = rs.getString("image");
                long price = rs.getInt("Price");
                long quantity =rs.getInt("quantity");
                long cash = rs.getInt("cash");
                customer = new Customer(id,drinks,image,price,quantity,cash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean EditCustomer(Customer customer) {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_SQL);
            preparedStatement.setLong(1, customer.getQuantity());
            preparedStatement.setInt(2, customer.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }


}
