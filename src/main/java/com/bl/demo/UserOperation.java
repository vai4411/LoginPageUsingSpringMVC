package com.bl.demo;

import java.sql.ResultSet;

public interface UserOperation {
    static int setEntries(String userName, String actualPassword, String email) {
        return 0;
    }

    static ResultSet getEntries(String userName, String password) {
        return null;
    }
}
