package com.carparking.adminlogin;

import com.carparking.repository.Repository;
import com.carparking.statuscalls.LoginStatusCall;

public class AdminLoginModel implements AdminLoginModelCallback {
    AdminLoginModelControllerCallback adminLoginController;

    AdminLoginModel(AdminLoginModelControllerCallback adminLoginController) {
        this.adminLoginController = adminLoginController;
    }

    @Override
    public void login(String adminId, String password) {
        LoginStatusCall loginStatusCall = Repository.getInstance().login(adminId, password);
        switch (loginStatusCall.getStatus()){
            case "SUCCESS" -> adminLoginController.loginSuccess(loginStatusCall.getAdmin());
            case "INCORRECT PASSWORD" -> adminLoginController.invalidMessage("admin incorrect password");
            case "NOT EXIST" -> adminLoginController.invalidMessage("admin doesn't exist");
        }
    }
}