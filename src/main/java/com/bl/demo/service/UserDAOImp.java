package com.bl.demo.service;

import com.bl.demo.model.User;
import com.bl.demo.model.UserDAO;
import com.bl.demo.repository.DBConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImp implements UserDAO {

    static Connection connection;
    static PreparedStatement ps;
    @Override
    public int insertUser(User user) {
        int status = 0;
        try {
            connection = DBConnectionProvider.getConnection();
            ps = connection.prepareStatement("insert into demo (name,password,email,date) values (?,?,?,?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getDatetime());
            status = ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public User getUser(String username, String password) {
        User user = new User();
        try {
            connection = DBConnectionProvider.getConnection();
            ps = connection.prepareStatement("select * from demo where name = ? and password = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setDatetime(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
