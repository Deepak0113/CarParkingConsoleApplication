package com.carparking.dto;

public class Credential extends Admin{
    private String password;

    public Credential(String adminId, String adminName, String password) {
        super(adminId, adminName);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
