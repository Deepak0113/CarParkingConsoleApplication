package com.carparking.checkout;

import com.carparking.dto.Admin;

public interface CheckOutViewControllerCallback {
    void chooseOption(String option, Admin admin);
    void checkOutCar(Admin admin, String carNumber);
}
