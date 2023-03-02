package com.carparking.checkin;

import com.carparking.dto.Admin;
import com.carparking.repository.Repository;
import com.carparking.statuscalls.ParkingStatusCall;

public class CheckInModel implements CheckInModelCallback {
    CheckInModelControllerCallback checkInController;

    CheckInModel(CheckInModelControllerCallback checkInController) {
        this.checkInController = checkInController;
    }

    @Override
    public void checkInCar(Admin admin, String carNumber, String carName, String carType) {
        ParkingStatusCall parkingStatusCall = Repository.getInstance().checkInCar(carNumber, carName, carType);
        switch (parkingStatusCall.getStatus()){
            case "FULL" -> checkInController.invalidMessage("No enough space to park", admin);
            case "EXIST" -> checkInController.invalidMessage("Already vehicle parked", admin);
            case "PARKED" -> checkInController.parkedSuccess(admin, parkingStatusCall.getParkingNumber());
        }
    }
}