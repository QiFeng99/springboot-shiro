package com.example.springbootshiro.po;

public class User {

    private String name;
    private Integer id;
    private String password;
    private String perms;

    public User(String name, Integer id, String password, String perms) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.perms = perms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}
