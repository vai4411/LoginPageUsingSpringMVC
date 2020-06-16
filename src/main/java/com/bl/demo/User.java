package com.bl.demo;

public class User {
    private String name;
    private String password;
    private String email;
    private String datetime;

    public User(String name, String password, String email, String datetime) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getDatetime() {
        return datetime;
    }
}
