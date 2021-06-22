package com.example.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    List<User> userList = new ArrayList<>();
    public List<User> dummyData() throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        userList.add(new User("Long","123","Hoang Long",20,formatDate.parse("2/3/2000"),false));
        userList.add(new User("Long","123","Hoang Long",20,formatDate.parse("9/6/2000"),false));
        userList.add(new User("Long","123","Hoang Long",20,formatDate.parse("10/3/2000"),false));
        userList.add(new User("Long","123","Hoang Long",20,formatDate.parse("2/9/2000"),false));
        userList.add(new User("Long","123","Hoang Long",20,formatDate.parse("11/3/2000"),false));
    return userList;

    }

    public List<User> getAll(){
        return userList;
    }

}
