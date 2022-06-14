package com.cg.service;

import com.cg.model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillService {

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

    private static final String BILL_SQL = "SELECT id_bill,dateExport,name,Drinks,Price,quantity,tien_gui,oder,tien_du FROM vw_bill;";
    private static final String ADD_BILL_SQL = "INSERT INTO `bill` (user_id,cart_id,tien_gui) VALUE (?,?,?)";

    public void AddBill(Bill bill){
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BILL_SQL);
            preparedStatement.setInt(1,bill.getCart_id());
            preparedStatement.setInt(2,bill.getCart_id());
            preparedStatement.setLong(3,bill.getTien_gui());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public List<Bill> SELECTBILL(){
        List<Bill> billList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BILL_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_bill = rs.getInt("id_bill");
                Date dateExport = rs.getDate("dateExport");
                String name =rs.getString("name");
                String Drinks = rs.getString("Drinks");
                long Price = rs.getLong("Price");
                long  quantity = rs.getLong("quantity");
                long tien_gui =rs.getLong("tien_gui");
                long oder =rs.getLong("oder");
                long tien_du =rs.getLong("tien_du");
                billList.add(new Bill(id_bill,dateExport,name,Drinks,Price,quantity,tien_gui,oder,tien_du));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

}
