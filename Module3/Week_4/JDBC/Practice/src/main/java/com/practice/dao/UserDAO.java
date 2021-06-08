package com.practice.dao;

import com.practice.model.Account;
import com.practice.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
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


//    private static final String SORT_USERS_SQL = "select * from users ORDER BY name";
//    public List<User> sortByName() {
//        // using try-with-resources to avoid closing resources (boiler plate code)
//        List<User>userList = new ArrayList<>();
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL);) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                userList.add(new User(id, name, email, country));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return userList;
//    }

    private static final String ACCOUNT_USER = "select username,password from account where username = ? and password = ?;";
    public Account accounts(String username,String password) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(ACCOUNT_USER);) {
            ps.setString(1,username);
            ps.setString(2,password);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new Account(username,password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }


    private static final String SEARCH_USERS_SQL ="select * from users where country like  ? or name like  ? or email like ?;";
    public List<User> searchUsers(String keyword) throws SQLException {
        String keyWord = "%"+keyword+"%";
        List<User> userList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_SQL);
        preparedStatement.setString(1, keyWord);
        preparedStatement.setString(2, keyWord);
        preparedStatement.setString(3, keyWord);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            userList.add(new User(id, name, email, country));
        }
        return userList ;
    }




    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " + " (?, ?, ?);";

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    private static final String SELECT_ALL_USERS = "select * from users ORDER BY name";
    public List<User> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?";
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

