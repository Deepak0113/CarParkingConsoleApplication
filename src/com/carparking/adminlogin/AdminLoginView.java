package com.carparking.adminlogin;

import com.carparking.dto.Admin;
import com.carparking.home.HomeView;

import java.util.Scanner;

public class AdminLoginView implements AdminLoginViewCallback {
    private AdminLoginViewControllerCallback adminLoginController;
    private final Scanner scanner = new Scanner(System.in);

    public AdminLoginView() {
        adminLoginController = new AdminLoginController(this);
    }

    public void startAdminLogin(){
        System.out.println("Admin login");
        System.out.println("------------------------------");
        System.out.print("Enter username: ");
        String adminId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        adminLoginController.login(adminId, password);
    }

    @Override
    public void loginSuccess(Admin admin) {
        System.out.println("Logged in successfully. Welcome " + admin.getAdminName());
        new HomeView().startHomeView(admin);
    }

    @Override
    public void invalidMessage(String message) {
        System.out.println(message);
        startAdminLogin();
    }
}