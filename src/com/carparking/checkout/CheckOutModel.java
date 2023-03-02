package com.carparking.checkout;

import com.carparking.dto.Admin;
import com.carparking.repository.Repository;
import com.carparking.statuscalls.ParkingStatusCall;

public class CheckOutModel implements CheckOutModelCallback {
    CheckOutModelControllerCallback checkOutController;

    CheckOutModel(CheckOutModelControllerCallback checkOutController) {
        this.checkOutController = checkOutController;
    }

    @Override
    public void checkOutCar(Admin admin, String carNumber) {
        ParkingStatusCall parkingStatusCall = Repository.getInstance().checkOutCar(carNumber);
        switch (parkingStatusCall.getStatus()){
            case "SUCCESS" -> checkOutController.checkOutSuccess(parkingStatusCall.getVehicle(), admin);
            case "NOT EXIST" -> checkOutController.invalidMessage("NOT EXIST", admin);
        }
    }
}