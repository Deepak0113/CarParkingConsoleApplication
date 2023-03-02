package com.carparking.adminlogin;

import com.carparking.dto.Admin;

public interface AdminLoginModelControllerCallback {
    void loginSuccess(Admin admin);
    void invalidMessage(String adminIncorrectPassword);
}
