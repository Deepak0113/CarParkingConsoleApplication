package com.carparking.checkin;

import com.carparking.dto.Admin;
import com.carparking.dto.Vehicle;
import com.carparking.utility.Validation;

public class CheckInController implements CheckInViewControllerCallback, CheckInModelControllerCallback {
    private CheckInViewCallback checkInView;
    private CheckInModelCallback checkInModel;

    CheckInController(CheckInViewCallback checkInView) {
        this.checkInView = checkInView;
        checkInModel = new CheckInModel(this);
    }

    @Override
    public void chooseOption(String option, Admin admin) {
        if(!Validation.validateOption(option)){
            checkInView.invalidMessage("Invalid option", admin);
        } else{
            switch (option){
                case "1" -> checkInView.checkIn(admin);
                case "2" -> checkInView.gotoHome(admin);
                case "9" -> System.exit(0);
            }
        }
    }

    @Override
    public void checkInCar(Admin admin, String carNumber, String carName, String carType) {
        checkInModel.checkInCar(admin, carNumber, carName, carType);
    }

    @Override
    public void parkedSuccess(Admin admin, String parkingNumber) {
        checkInView.parkedSuccess(admin, parkingNumber);
    }

    @Override
    public void invalidMessage(String message, Admin admin) {
        checkInView.invalidMessage(message, admin);
    }
}