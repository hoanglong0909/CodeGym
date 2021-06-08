package com.DAO;

import com.model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements iStaff {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/staff?useSSL=false";
    private String jdbcUser = "root";
    private String password = "admin";
    private static final String SEARCH_STAFF = "select * from staffmanager where id like ? or fullName like ?;";
    private static final String INSERT_STAFF = "INSERT INTO staffmanager (groupStaff, fullName, gender, phoneNumber,dob,cmndNumber,email) VALUES (?,?,?,?,?,?,?);";
    private static final String SELECT_PRODUCT_ID = "SELECT * FROM staffmanager where id = ?";
    private static final String SELECT_ALL_STAFF = "SELECT * FROM staffmanager;";
    private static final String DELETE_STAFF = "DELETE FROM staffmanager WHERE (id = ?);";
    private static final String UPDATE_STAFF = "UPDATE staffmanager set groupStaff = ?, fullName= ?, gender = ?, phoneNumber = ?, dob = ?, cmndNumber =?, email = ? where id = ?;";
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, jdbcUser, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(Staff staff) throws SQLException {
        System.out.println(INSERT_STAFF);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF)) {
            preparedStatement.setString(1, staff.getGroupStaff());
            preparedStatement.setString(2, staff.getFullName());
            preparedStatement.setString(3, staff.getGender());
            preparedStatement.setString(4, staff.getPhoneNumber());
            preparedStatement.setString(5, staff.getDob());
            preparedStatement.setString(6, staff.getCmndNumber());
            preparedStatement.setString(7, staff.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public Staff select(int id) throws SQLException {
        Staff staff = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String groupStaff = rs.getString("groupStaff");
                String fullName = rs.getString("fullName");
                String gender = rs.getString("gender");
                String phoneNumber = rs.getString("phoneNumber");
                String dob = rs.getString("dob");
                String cmndNumber = rs.getString("cmndNumber");
                String email = rs.getString("email");
                staff = new Staff(id, groupStaff, fullName, gender, phoneNumber, dob,cmndNumber,email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }

@Override
    public List<Staff> selectAll() throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFF)){
            System.out.println(preparedStatement);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String groupStaff = rs.getString("groupStaff");
                    String fullName = rs.getString("fullName");
                    String gender = rs.getString("gender");
                    String phoneNumber = rs.getString("phoneNumber");
                    String dob = rs.getString("dob");
                    String cmndNumber = rs.getString("cmndNumber");
                    String email = rs.getString("email");
                    staffList.add(new Staff(id, groupStaff, fullName, gender, phoneNumber, dob,cmndNumber,email));
                }
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return staffList;
    }


    @Override
    public boolean delete(int id) throws SQLException {
        boolean RowDelete;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STAFF);
        preparedStatement.setInt(1, id);
        RowDelete = preparedStatement.executeUpdate() > 0;
        return RowDelete;
    }


    @Override
    public boolean update(Staff staff) throws SQLException {
        boolean Update;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STAFF)){
            preparedStatement.setString(1, staff.getGroupStaff());
            preparedStatement.setString(2, staff.getFullName());
            preparedStatement.setString(3, staff.getGender());
            preparedStatement.setString(4, staff.getPhoneNumber());
            preparedStatement.setString(5, staff.getDob());
            preparedStatement.setString(6, staff.getCmndNumber());
            preparedStatement.setString(7, staff.getEmail());
            preparedStatement.setInt(8,staff.getId());
            Update = preparedStatement.executeUpdate() > 0;

        }
        return Update;
    }

    public List<Staff> searchProduct(String keyword) {
        String keyWord = "%" + keyword + "%";
        List<Staff> staffList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STAFF)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, keyWord);
            preparedStatement.setString(2, keyWord);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String groupStaff = rs.getString("groupStaff");
                String fullName = rs.getString("fullName");
                String gender = rs.getString("gender");
                String phoneNumber = rs.getString("phoneNumber");
                String dob = rs.getString("dob");
                String cmndNumber = rs.getString("cmndNumber");
                String email = rs.getString("email");
                staffList.add(new Staff(id, groupStaff, fullName, gender, phoneNumber, dob,cmndNumber,email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffList;
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


