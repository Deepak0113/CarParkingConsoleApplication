package com.carparking.adminlogin;

import com.carparking.dto.Admin;

public interface AdminLoginViewCallback {
    void loginSuccess(Admin admin);
    void invalidMessage(String message);
}