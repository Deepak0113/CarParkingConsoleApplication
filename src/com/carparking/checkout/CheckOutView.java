package com.carparking.checkout;

import com.carparking.dto.Admin;
import com.carparking.dto.Vehicle;
import com.carparking.home.HomeView;

import java.util.Scanner;

public class CheckOutView implements CheckOutViewCallback {
    private final CheckOutViewControllerCallback checkOutController;
    private final Scanner scanner = new Scanner(System.in);

    public CheckOutView() {
        checkOutController = new CheckOutController(this);
    }

    public void startCheckOut(Admin admin){
        System.out.println("\n1. Continue check out");
        System.out.println("2. Home");
        System.out.println("9. Exit");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        checkOutController.chooseOption(option, admin);
    }

    @Override
    public void invalidMessage(String message, Admin admin) {
        System.out.println(message);
        startCheckOut(admin);
    }

    @Override
    public void checkOut(Admin admin) {
        System.out.println("Check out");
        System.out.println("------------------------------");
        System.out.println("Enter car number: ");
        String carNumber = scanner.nextLine();

        checkOutController.checkOutCar(admin, carNumber);
    }

    @Override
    public void gotoHome(Admin admin) {
        new HomeView().startHomeView(admin);
    }

    @Override
    public void checkOutSuccess(Vehicle vehicle, Admin admin) {
        System.out.println(vehicle);
        System.out.println("------ Parking cleared ------");
        gotoHome(admin);
    }
}