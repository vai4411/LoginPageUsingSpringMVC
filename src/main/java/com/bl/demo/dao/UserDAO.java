package com.bl.demo.dao;

import com.bl.demo.model.User;

public interface UserDAO {

    int insertUser(User user);
    User getUser(String username, String password);
}
