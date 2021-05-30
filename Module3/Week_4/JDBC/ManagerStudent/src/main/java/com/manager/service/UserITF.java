package com.manager.service;

import com.manager.model.User;

import java.util.List;

public interface UserITF {
     void insertUser(User user);
     User selectUser(int id);
     List<User>selectUserALL();
     boolean deleteUser(int id);
     boolean updateUser(User user);
}
