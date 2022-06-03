package service;

import model.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersServece {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bank?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0379825939";


    private static final String SQL_VIEW = "SELECT cs.id,cs.full_name,cs.email,cs.phone,cs.address,cs.balance FROM customers cs WHERE deleted = '0';";
    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customers (full_name,email,phone,address) VALUE (?,?,?,?);";
    private static final String UPDATE_CUSTOMERS_SQL = "UPDATE customers SET full_name = ? , email = ?,phone = ? , address = ? WHERE id = ?;";
    private static final String BY_ID_CUSTOMERS_SQL = "SELECT full_name,email,phone,address FROM customers WHERE id = ?;";
    private static final String BY_ID_CUSTOMERSDEPOSIT_SQL = "SELECT id,full_name,balance FROM customers WHERE id = ?;";
    private static final String BY_ID_CUSTOMERSTRANSFER_SQL = "SELECT id,full_name,email,balance FROM customers WHERE id = ?;";
    private static final String DEPOSIT_CUSTOMERS_SQL = " CALL bank.sp_deposit(?,?);";
    private static final String Transfer_CUSTOMERS_SQL = "call bank.sp_transaction(?, ?, ?);";
    private static final String DELETE_CUSTOMERS_SQL = "UPDATE customers cs SET cs.deleted = '1' WHERE id = ?;";
    private static final String WITHDRAW_CUSTOMERS_SQL = "call bank.sp_withdraws(?,?);";


    public CustomersServece() {

    }

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


    public List<Customers> SelectUser() {
        List<Customers> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_VIEW);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Long balance = rs.getLong("balance");
                customers.add(new Customers(id, name, email, phone, address, balance));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Boolean AddCustomers(Customers customers) throws SQLException {
        boolean inserted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL);
            preparedStatement.setString(1, customers.getFull_name());
            preparedStatement.setString(2, customers.getEmail());
            preparedStatement.setString(3, customers.getPhone());
            preparedStatement.setString(4, customers.getAddress());
            preparedStatement.executeUpdate();
            inserted = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inserted;
    }

    public Customers ShowCustomers(int id) {
        Customers customers = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BY_ID_CUSTOMERS_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String full_name = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                customers = new Customers(full_name, email, phone, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;

    }

    public Customers ShowDeposit(int id) {
        Customers customers = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BY_ID_CUSTOMERSDEPOSIT_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String full_name = resultSet.getString("full_name");
                Long balance = resultSet.getLong("balance");
                customers = new Customers(id, full_name, balance);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;

    }

    public Customers ShowTransfer(int id) {
        Customers customers = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BY_ID_CUSTOMERSTRANSFER_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String full_name = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                Long balance = resultSet.getLong("balance");
                customers = new Customers(id, full_name, email, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;

    }

    public boolean EditCustomers(Customers customers) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);
            preparedStatement.setString(1, customers.getFull_name());
            preparedStatement.setString(2, customers.getEmail());
            preparedStatement.setString(3, customers.getPhone());
            preparedStatement.setString(4, customers.getAddress());
            preparedStatement.setInt(5, customers.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;

    }

    public boolean DepositCustomers(Customers customers) {

        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(DEPOSIT_CUSTOMERS_SQL);
            callableStatement.setLong(2, customers.getBalance());
            callableStatement.setInt(1, customers.getId());
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowUpdated;
    }


    public boolean Transfer(Customers customers) {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(Transfer_CUSTOMERS_SQL);
            callableStatement.setInt(1, customers.getId());
            callableStatement.setInt(2, customers.getIds());
            callableStatement.setLong(3, customers.getTransferAmount());
            callableStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean deleteCustomers(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean WithdrawCustomers(Customers customers) {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(WITHDRAW_CUSTOMERS_SQL);
            callableStatement.setLong(2, customers.getBalance());
            callableStatement.setInt(1, customers.getId());
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowUpdated;
    }


}