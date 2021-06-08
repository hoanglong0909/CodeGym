package com.manager.service;

import java.sql.SQLException;
import java.util.List;

public interface UserITF {
     void insertUser(User user);
     User selectUser(int id);
     List<User>selectUserALL();
     boolean deleteUser(int id) throws SQLException;
     boolean updateUser(User user) throws SQLException;
}
