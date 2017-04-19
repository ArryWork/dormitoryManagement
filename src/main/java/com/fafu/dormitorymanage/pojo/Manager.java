package com.fafu.dormitorymanage.pojo;

public class Manager {
    private Integer id;

    private String account;

    private String password;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer managedDomitoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getManagedDomitoryId() {
        return managedDomitoryId;
    }

    public void setManagedDomitoryId(Integer managedDomitoryId) {
        this.managedDomitoryId = managedDomitoryId;
    }
}