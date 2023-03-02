package com.carparking.home;

import com.carparking.adminlogin.AdminLoginView;
import com.carparking.checkin.CheckInView;
import com.carparking.checkout.CheckOutView;
import com.carparking.dto.Admin;

import java.util.Scanner;

public class HomeView implements HomeViewCallback {
    private HomeViewControllerCallback homeController;
    private final Scanner scanner = new Scanner(System.in);

    public HomeView() {
        homeController = new HomeController(this);
    }

    public void startHomeView(Admin admin){
        System.out.println("\nHome");
        System.out.println("------------------------------");
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. Logout");
        System.out.println("9. Exit");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        homeController.chooseOption(option, admin);
    }

    @Override
    public void invalidMessage(String invalidOption, Admin admin) {
        System.out.println("Invalid option");
        startHomeView(admin);
    }

    @Override
    public void gotoCheckIn(Admin admin) {
        new CheckInView().startCheckIn(admin);
    }

    @Override
    public void gotoCheckOut(Admin admin) {
        new CheckOutView().startCheckOut(admin);
    }

    @Override
    public void logout(Admin admin) {
        homeController.logoutAdmin(admin);
        new AdminLoginView().startAdminLogin();
    }
}