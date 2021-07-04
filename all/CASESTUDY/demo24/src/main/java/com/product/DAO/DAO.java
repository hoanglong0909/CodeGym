package com.product.DAO;


import com.product.model.Category;
import com.product.model.Electronic;
import com.product.model.Login;
import com.product.service.iElectronic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements iElectronic {
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

    private static final String SEARCH_PRODUCT ="SELECT * FROM product where name like ?";
    public List<Electronic> searchElectronic(String keyword) throws SQLException {
        String keyWord = "%"+keyword+"%";
        List<Electronic> electronicList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT);
        preparedStatement.setString(1, keyWord);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            electronicList.add(new Electronic(id, name));
        }
        return electronicList ;
    }
    private static final String LOGIN_PRODUCT = "SELECT * from login where userName = '?' and passWord = ?;";
    private static final String GET_PRODUCT_BY_ID_CATEGORY = "SELECT * FROM product where categoryId = ?";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM product where id = ?";
    private static final String INSERT_PRODUCT= "INSERT INTO product(name, image,price,categoryId) VALUES ('?','?',?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT id,name,image,price from product where id = ? ;";
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?";
    private static final String SELECT_CATEGORY_BY_ID = "SELECT id,name from category where id = ? ;";


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

    public Login account(String username, String password) {
        String userName = username;
        String passWord = password;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_PRODUCT)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String userNames = rs.getString("userName");
                String passWords = rs.getString("passWord");
                int isSell = rs.getInt("passWord");
                int isAdmin = rs.getInt("passWord");
                return new Login(id, userNames, passWords,isSell,isAdmin);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }


    private static final String SEARCH_PRODUCT_BY_NAME ="SELECT * FROM product where 'name' like ? ;";
    public List<Electronic> searchProduct(String keyword) {
        String keyWord = "%" + keyword + "%";
        List<Electronic> electronicList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_NAME)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, keyWord);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                Float price = rs.getFloat("price");
                electronicList.add(new Electronic(id,name,image,price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return electronicList;
    }

    @Override
    public void insert(Electronic electronic) throws SQLException {
        System.out.println(INSERT_PRODUCT);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1, electronic.getName());
            preparedStatement.setString(2, electronic.getImage());
            preparedStatement.setFloat(3, electronic.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Electronic select(int id) throws SQLException {
        Electronic electronic = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                Float price = Float.valueOf(rs.getString("price"));
                electronic = new Electronic(id, name, image, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return electronic;
    }

    @Override
    public List<Electronic> selectAll() throws SQLException {
        List<Electronic> electronicList = new ArrayList<>();
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                Float price = rs.getFloat("price");
                electronicList.add(new Electronic(id, name, image, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return electronicList;
    }

    @Override
    public List<Electronic> getProductCid(int id) throws SQLException {
        List<Electronic> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID_CATEGORY)) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                Float price = rs.getFloat("price");
                list.add(new Electronic(id, name, image, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    @Override
    public Electronic getProductById(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID)) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                Float price = rs.getFloat("price");
                return new Electronic (id, name, image, price);
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Electronic electronic) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Category selectCategory(int id) throws SQLException {
        Category category = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }
    public static final String SELECT_CATEGORY_ALL = "SELECT * from category";
    @Override
    public List<Category> selectCategoriesAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_ALL)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }
}
