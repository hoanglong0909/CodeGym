package com.manager.service;

import com.manager.model.Student;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {

    private String jdbcUrl ="jdbc:mysql://localhost:3306/student_manager?useSSL=false";
    private String jdbcUser = "root";
    private String password ="admin";

    private static final String INSERT_USERS_SQL = "INSERT INTO managerstudent" + "  (name, gender, email,phone,age) VALUES " +
            " (?, ?, ?, ?, ?);";


    private static final String SEARCH_STUDENT = "select * from managerstudent where name like ?or gender like ?or email like ? or phone like ? or age like ? ;";

    public List<Student>searchStudent(String keyword){
        String keyWord = "%" +keyword+ "%";
        List<Student> studentList = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENT)){
            System.out.println(preparedStatement);
            preparedStatement.setString(1,keyWord);
            preparedStatement.setString(2,keyWord);
            preparedStatement.setString(3,keyWord);
            preparedStatement.setString(4,keyWord);
            preparedStatement.setString(5,keyWord);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                studentList.add(new Student(id,name,gender,email,phone,age));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return studentList;
    }

    private static final  String SORT_STUDENT = "select * from managerstudent ORDER BY name;";

    public List<Student> sortStudent(){
        List<Student>studentList =new ArrayList<>();
         try(Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_STUDENT)){
             System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();
             while(rs.next()){
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 String gender = rs.getString("gender");
                 String email = rs.getString("email");
                 String phone = rs.getString("phone");
                 int age = rs.getInt("age");
                 studentList.add(new Student(id,name,gender,email,phone,age));
             }
     }catch (SQLException e){
             printSQLException(e);
         }
         return studentList;
    }

    public StudentDAO() {
    }


    private Connection getConnection(){
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
    public void insertStudentDAO(Student student) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getGender());
        preparedStatement.setString(3,student.getEmail());
        preparedStatement.setString(4,student.getPhone());
        preparedStatement.setInt(5,student.getAge());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    private static final String SELECT_USER_BY_ID = "select id,name,gender,email,phone,age from managerstudent where id =?";
    public Student selectStudentDAO(int id) {
        Student student = null;
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
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                student = new Student(name, gender, email, phone, age);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

        private static final String SELECT_ALL_USERS = "select * from managerstudent";
    @Override
    public List<Student> selectStudentAll() throws SQLException {
        // sử dụng thử với tài nguyên để tránh việc đóng tài nguyên (mã tấm nồi hơi)
        List<Student> studentList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int age = rs.getInt("age");
            studentList.add(new Student(id,name,gender,email,phone,age));
        }
        return studentList;
    }

    private static final String DELETE_USERS_SQL = "delete from managerstudent where id = ?;";
    @Override
    public boolean deleteStudentDAO(int id) throws SQLException {
        boolean RowDelete;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
        preparedStatement.setInt(1,id);
        RowDelete = preparedStatement.executeUpdate() > 0;
        return RowDelete ;

    }

    private static final String UPDATE_USERS_SQL = "update managerstudent set name = ?, gender= ?, email =?, phone =?, age =? where id = ?;";
    @Override
    public boolean updateStudentDAO(Student student) throws SQLException {
        boolean Update;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getGender());
        preparedStatement.setString(3,student.getEmail());
        preparedStatement.setString(4,student.getPhone());
        preparedStatement.setInt(5, student.getAge());
        preparedStatement.setInt(6, student.getId());
        Update = preparedStatement.executeUpdate()>0;
        return Update;
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

