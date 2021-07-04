package com.account.service;

import com.account.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends CSDL{

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

