package com.carparking.adminlogin;

import com.carparking.dto.Admin;

public class AdminLoginController implements AdminLoginViewControllerCallback, AdminLoginModelControllerCallback {
    private AdminLoginViewCallback adminLoginView;
    private AdminLoginModelCallback adminLoginModel;

    AdminLoginController(AdminLoginViewCallback adminLoginView) {
        this.adminLoginView = adminLoginView;
        adminLoginModel = new AdminLoginModel(this);
    }

    @Override
    public void login(String adminId, String password) {
        adminLoginModel.login(adminId, password);
    }

    @Override
    public void loginSuccess(Admin admin) {
        adminLoginView.loginSuccess(admin);
    }

    @Override
    public void invalidMessage(String message) {
        adminLoginView.invalidMessage(message);
    }
}