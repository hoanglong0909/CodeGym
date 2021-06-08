package com.gaming.CSDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Gaming {
    private String jdbcURL = "jdbc:mysql://localhost:3306/gaming?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    public Gaming() {
    }
    public Connection getConnection() {
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

    public static final String INSERT_CLIENT_SQL = "INSERT INTO client" + " (nameClient) VALUES " + " (?);";
    public static final String SELECT_CLIENT_UBY_ID ="SELECT idClient,nameClient from client where idClient =?";
    public static final String SELECT_ALL_CLIENT= "SELECT * from client";
    public static final String DELETE_CLIENT_SQL = "DELETE from client where idClient = ?;";
    public static final String UPDATE_CLIENT_SQL = "UPDATE client set nameClient =? where idClient = ?";
    public static final String SELECT_ALL_CLIENT_WITH_MACHINE = "select C.idClient,C.nameClient\n" +
            ",M.machineStatus\n" +
            ",S.nameProduct,S.accountProduct,S.accountTime\n" +
            ",mn.totalMoney\n" +
            "from client C\n" +
            "join machine M \n" +
            "on C.idClient = M.idClient\n" +
            "join service S\n" +
            "on M.idMachine = S.idMachine\n" +
            "join money mn\n" +
            "on mn.idMoney = S.idMoney ;";

}
