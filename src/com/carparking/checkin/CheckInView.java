package com.carparking.checkin;

import com.carparking.dto.Admin;
import com.carparking.home.HomeView;

import java.util.Scanner;

public class CheckInView implements CheckInViewCallback {
    private CheckInViewControllerCallback checkInController;
    private final Scanner scanner = new Scanner(System.in);

    public CheckInView() {
        checkInController = new CheckInController(this);
    }

    public void startCheckIn(Admin admin){
        System.out.println("\n1. Continue check in");
        System.out.println("2. Home");
        System.out.println("9. Exit");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        checkInController.chooseOption(option, admin);
    }

    @Override
    public void invalidMessage(String message, Admin admin) {
        System.out.println(message);
        startCheckIn(admin);
    }

    @Override
    public void checkIn(Admin admin) {
        System.out.println("\nCheck In");
        System.out.println("------------------------------");
        System.out.print("Enter car number: ");
        String carNumber = scanner.nextLine();
        System.out.print("Enter car name: ");
        String carName = scanner.nextLine();
        System.out.print("Enter car type: ");
        String carType = scanner.nextLine();

        checkInController.checkInCar(admin, carNumber, carName, carType);
    }

    @Override
    public void gotoHome(Admin admin) {
        new HomeView().startHomeView(admin);
    }

    @Override
    public void parkedSuccess(Admin admin, String parkingNumber) {
        System.out.println("Parked successfully");
        System.out.println("Parking number: " + parkingNumber);
        gotoHome(admin);
    }
}