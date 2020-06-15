package com.bl.demo.database;

import java.sql.*;

public class DBConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/register","Vaibhav","Vaibhav@123");
    }

    public static void closeConnection() throws SQLException, ClassNotFoundException {
        getConnection().close();
    }

    public static Statement getStatement() throws SQLException, ClassNotFoundException {
        return getConnection().createStatement();
    }

    public static void closeStatement() throws SQLException, ClassNotFoundException {
        getStatement().close();
    }

    public static int setEntries(String userName, String actualPassword, String email) throws SQLException, ClassNotFoundException {
        return getStatement().executeUpdate("insert into demo(name,password,email,date) values(\'"+userName+"\',\'"+actualPassword+"\',\'"+email+"\', now())");
    }

    public static ResultSet getEntries(String userName, String password) throws SQLException, ClassNotFoundException {
        return getStatement().executeQuery("select * from demo where name=\'"+userName+"\' AND password=\'"+password+"\'");
    }
}
