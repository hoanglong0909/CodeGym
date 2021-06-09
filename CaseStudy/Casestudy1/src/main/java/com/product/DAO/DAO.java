package com.product.DAO;

import com.product.model.Category;
import com.product.model.Electronic;
import com.product.model.Login;
import com.product.service.iElectronic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DAO extends CSDL implements iElectronic {
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
            String image = rs.getString("image");
            Float price = rs.getFloat("price");
            electronicList.add(new Electronic(id, name,image,price));
        }
        return electronicList ;
    }
    private static final String CHECK_LOGIN_PRODUCT = "SELECT * from login where userName = ?;";
    private static final String LOGIN_PRODUCT = "SELECT * from login where userName = ? and passWord = ?;";
    private static final String GET_PRODUCT_BY_ID_CATEGORY = "SELECT * FROM product where categoryId = ?";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM product where id = ?";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT id,name,image,price from product where id = ? ;";
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM product order by id desc";
    private static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
    private static final String SELECT_CATEGORY_BY_ID = "SELECT id,name from category where id = ? ;";
    private static final String INSERT_ACCOUNT= "INSERT INTO login(userName,passWord,email,isSell,isAdmin) VALUES (?,?,?,0,0);";
    public static final String SELECT_CATEGORY_ALL = "SELECT * from category";



    public void signup(String userName,String passWord,String email) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            preparedStatement.setString(3, email);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
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

    public Login account(String username, String password) {
        String userNames = username;
        String passWords = password;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_PRODUCT)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, userNames);
            preparedStatement.setString(2, passWords);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String userName = rs.getString(2);
                String passWord = rs.getString(3);
                String email = rs.getString(4);
                int isSell = rs.getInt(5);
                int isAdmin = rs.getInt(6);
                return new Login(id, userName, passWord,email,isSell,isAdmin);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }



    public Login acountCheckExist(String username) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN_PRODUCT)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String userNames = rs.getString("userName");
                return new Login(id, userNames);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
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

    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
        List<Electronic> electronicList = dao.selectAll();
        for (Electronic e: electronicList
             ) {
            System.out.println(e);
        }
    }



    @Override
    public List<Electronic> getProductCid(int Cid) throws SQLException {
        List<Electronic> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID_CATEGORY)) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, Cid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                Float price = rs.getFloat("price");
                int id = rs.getInt("id");
                list.add(new Electronic(id, name, image, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
//        return  null;
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
                Float price = Float.parseFloat(rs.getString("price"));
                electronic = new Electronic(id, name, image, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return electronic;
    }
//    @Override
//    public Electronic getProductById(int id) throws SQLException {
//        Electronic electronic = null;
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID)) {
//            System.out.println(preparedStatement);
//            preparedStatement.setInt(1,id);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String image = rs.getString("image");
//                Float price = rs.getFloat("price");
//                electronic = new Electronic (name, image, price);
//            }
//        }
//        return electronic;
//    }



    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


    private static final String UPDATE_PRODUCT_SQL = "UPDATE product SET name = ?,image = ?, price = ?, categoryId =? WHERE id = ?;";
    @Override
    public boolean update(String name,String image,Float price,int categoryId,int id) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            statement.setString(1,name);
            statement.setString(2,image);
            statement.setFloat(3,price);
            statement.setInt(4,categoryId);
            statement.setInt(5,id);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Category selectCategory(int id) throws SQLException {
        return null;
    }

//    public void editProduct(S) throws SQLException {
//      Connection connection = getConnection();
//      PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
//      ResultSet rs = preparedStatement.executeQuery();
//      while (rs.next()){
//          String name = rs.getString(1,"name");
//      }
//    }
//
//
//

    @Override
    public Electronic getProductById(int id) throws SQLException {
        // Step 1: Establishing a Connection
        Electronic electronic = null;
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                Float price = rs.getFloat("price");
                electronic = new Electronic(id, name,image,price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return electronic;
    }




    @Override
    public List<Category> selectCategoriesAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
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
    private static final String GET_PRODUCT_BY_SELLID = "SELECT * from product where sell_id = ?;";
    @Override
    public List<Electronic> getProductBySellId(int sell_id) throws SQLException {
        List<Electronic> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_SELLID)) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,sell_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                Float price = rs.getFloat("price");
                list.add(new Electronic(id,name, image, price,sell_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }


    @Override
    public void insert(Electronic electronic) throws SQLException {
    }

    private static final String INSERT_PRODUCT= "INSERT INTO product(name, image,price,categoryId,sell_id) VALUES (?,?,?,?,?);";
    public void insertProduct(Electronic electronic) {
        System.out.println(INSERT_PRODUCT);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1,electronic.getName());
            preparedStatement.setString(2,electronic.getImage());
            preparedStatement.setFloat(3, electronic.getPrice());
            preparedStatement.setInt(4, electronic.getCategory_id());
            preparedStatement.setInt(5, electronic.getSell_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
