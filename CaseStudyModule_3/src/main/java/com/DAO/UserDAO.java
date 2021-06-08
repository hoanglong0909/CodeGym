package com.DAO;

import com.model.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";


    public UserDAO() {
    }


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

    private static final String ACCOUNT_USER = "select * from login where userName = ? and passWord = ?;";
    public Account accounts(String userName,String passWord) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(ACCOUNT_USER);) {
            ps.setString(1, userName);
            ps.setString(2, passWord);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(userName, passWord);
            }
        }
        return null;
    }
}

