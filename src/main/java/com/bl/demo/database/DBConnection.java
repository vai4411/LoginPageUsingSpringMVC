package com.bl.demo.database;

import com.bl.demo.UserOperation;

import java.sql.*;

public class DBConnection implements UserOperation {

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

    public static int setEntries(String userName, String actualPassword, String email) {
        try {
            return getStatement().executeUpdate("insert into demo(name,password,email,date) values(\'"+userName+"\',\'"+actualPassword+"\',\'"+email+"\', now())");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ResultSet getEntries(String userName, String password) {
        try {
            return getStatement().executeQuery("select * from demo where name=\'"+userName+"\' AND password=\'"+password+"\'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
