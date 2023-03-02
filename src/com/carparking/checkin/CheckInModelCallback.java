package com.carparking.checkin;

import com.carparking.dto.Admin;

public interface CheckInModelCallback {
    void checkInCar(Admin admin, String carNumber, String carName, String carType);
}