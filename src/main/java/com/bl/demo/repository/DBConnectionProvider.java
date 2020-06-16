package com.bl.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionProvider implements ConnectionProvider {
    static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connURL,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
