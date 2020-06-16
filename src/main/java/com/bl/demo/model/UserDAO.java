package com.bl.demo.model;

public interface UserDAO {

    int insertUser(User user);
    User getUser(String username, String password);
}
