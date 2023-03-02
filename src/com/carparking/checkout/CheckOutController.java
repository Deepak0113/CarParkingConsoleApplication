package com.carparking.checkout;

import com.carparking.dto.Admin;
import com.carparking.dto.Vehicle;
import com.carparking.utility.Validation;

public class CheckOutController implements CheckOutViewControllerCallback, CheckOutModelControllerCallback {
    private CheckOutViewCallback checkOutView;
    private CheckOutModelCallback checkOutModel;

    CheckOutController(CheckOutViewCallback checkOutView) {
        this.checkOutView = checkOutView;
        checkOutModel = new CheckOutModel(this);
    }

    @Override
    public void chooseOption(String option, Admin admin) {
        if(!Validation.validateOption(option)){
            checkOutView.invalidMessage("Invalid option", admin);
        } else{
            switch (option){
                case "1" -> checkOutView.checkOut(admin);
                case "2" -> checkOutView.gotoHome(admin);
                case "9" -> System.exit(0);
            }
        }
    }

    @Override
    public void checkOutCar(Admin admin, String carNumber) {
        checkOutModel.checkOutCar(admin, carNumber);
    }

    @Override
    public void checkOutSuccess(Vehicle vehicle, Admin admin) {
        checkOutView.checkOutSuccess(vehicle, admin);
    }

    @Override
    public void invalidMessage(String message, Admin admin) {
        checkOutView.invalidMessage(message, admin);
    }
}