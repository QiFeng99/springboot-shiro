package com.example.springbootshiro.po;

public class User {

    private String name;
    private String password;
    private Integer id;
    private String perms;

    public User(String name, String password, Integer id, String perms) {
        this.name = name;
        this.password = password;
        this.id = id;
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
