package com.manager.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserITF {

    private String jdbcURL = "jdbc:mysql://localhost:3306/user?useSSL=false";
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

    private final String SELECT_USER ="SELECT userName,passWord from user where id = ?;";
    private final String SELECT_USER_ALL = "select * from user ORDER BY userName;";
    private final String DELETE_USER = "DELETE FROM USER WHERE ID = ? ;";
    private final String INSERT_USER = "INSERT INTO user" + "(userName,passWord) VALUES " +
            " ('?','?');";
    private final String UPDATE_USER = "UPDATE FROM USER SET id ='?' userName = '?' passWord = '?' where(id =? )";
    private final String SORT_USER = "SELECT * from USER ORDER BY userName;";
    private final String SEARCH_USER = "SELECT * FROM  where id like ?,userName like '?',passWord like '?';";



    public  List<User> searchUser(String keyWord){
        String keyword = "%" + keyWord +"+" ;
        List<User>userList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER)){
                preparedStatement.setString(1,keyword);
                preparedStatement.setString(2,keyword);
                preparedStatement.setString(3,keyword);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String userName = rs.getString("userName");
                    String passWord = rs.getString("passWord");
                    userList.add(new User(id,userName,passWord));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return userList;
    }
    @Override
    public void insertUser(User user) {
        System.out.println(INSERT_USER);
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)){
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                user = new User(id,userName,passWord);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return user;
    }


    @Override
    public List<User> selectUserALL() {
        List<User> userList = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_ALL)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                userList.add(new User(id,userName,passWord));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }



    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)){
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
}
