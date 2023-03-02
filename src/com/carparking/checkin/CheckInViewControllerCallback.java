package com.carparking.checkin;

import com.carparking.dto.Admin;

public interface CheckInViewControllerCallback {

    void chooseOption(String option, Admin admin);

    void checkInCar(Admin admin, String carNumber, String carName, String carType);
}
