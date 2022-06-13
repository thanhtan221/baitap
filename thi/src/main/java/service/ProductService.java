package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/product?useSSL=false";
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


    private static final String View_PRODUCT_SQL = "SELECT pt.id,pt.product,pt.price,pt.quantity,pt.color,pt.category FROM product pt;";
    private static final String ADD_PRODUCT_SQL = "INSERT INTO product (product,price,quantity,color,category) VALUE (?,?,?,?,?);";
    private static final String EDIT_PRODUCT_SQL = "UPDATE product SET product =?,price = ?,quantity = ?,color=?,category = ? WHERE id = ?; ";
    private static final String BY_ID_PRODUCT_SQL = "select pt.id,pt.product,pt.price,pt.quantity,pt.color,pt.category FROM product pt WHERE pt.id = ?;";
    private static final String DELETE_PRODUCT_SQL = "delete from product Where id = ?;";
    private static final String SEACH_PRODUCT_SQL = "SELECT pt.id,pt.product,pt.price,pt.quantity,pt.color,pt.category  FROM product pt WHERE pt.product LIKE ?;";


    public List<Product> SeleProduct() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(View_PRODUCT_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("product");
                long price = rs.getLong("price");
                long quantity = rs.getLong("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                productList.add(new Product(id, name, price, quantity, color, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public Boolean AddUser(Product product) {
        boolean inserted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setLong(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategory());
            preparedStatement.executeUpdate();
            inserted = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inserted;
    }

    public Product Showproduct(int id) {
        Product product = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BY_ID_PRODUCT_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String name = resultSet.getString("product");
                long price = resultSet.getLong("price");
                long quantity = resultSet.getLong("quantity");
                String color = resultSet.getString("color");
                String category = resultSet.getString("category");
                product = new Product(id, name, price, quantity, color, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Boolean EditProduct(Product product) {
        boolean inserted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setLong(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategory());
            preparedStatement.setInt(6, product.getId());
            inserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inserted;
    }

    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;

    }

    public List<Product> Seachproduct(String name) {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEACH_PRODUCT_SQL);
            preparedStatement.setString(1,name + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int  id = resultSet.getInt("id");
                name = resultSet.getString("product");
                long price = resultSet.getLong("price");
                long quantity = resultSet.getLong("quantity");
                String color = resultSet.getString("color");
                String category = resultSet.getString("category");
              productList.add (new Product(id, name, price, quantity, color, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
