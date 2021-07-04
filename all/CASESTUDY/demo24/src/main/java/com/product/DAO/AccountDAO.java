package com.product.DAO;

import com.product.model.Account;

import java.sql.*;

public class AccountDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";



    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    private static final String ACCOUNT_USER = "select userName,passWord from login where userName = ? and passWord = ?;";

    public Account accounts(String username, String password) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(ACCOUNT_USER);) {
            ps.setString(1, username);
            ps.setString(2, password);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(username, password);
            }
        }
        return null;
    }
}

