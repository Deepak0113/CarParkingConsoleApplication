package com.carparking.statuscalls;

import com.carparking.dto.Admin;

public class LoginStatusCall extends Status{
    Admin admin;

    public LoginStatusCall(String status){
        super(status);
    }

    public LoginStatusCall(String status, Admin admin){
        super(status);
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }
}
