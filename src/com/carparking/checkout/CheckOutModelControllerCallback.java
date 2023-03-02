package com.carparking.checkout;

import com.carparking.dto.Admin;
import com.carparking.dto.Vehicle;

public interface CheckOutModelControllerCallback {
    void checkOutSuccess(Vehicle vehicle, Admin admin);
    void invalidMessage(String notExist, Admin admin);
}
