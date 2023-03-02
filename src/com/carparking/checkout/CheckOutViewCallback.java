package com.carparking.checkout;

import com.carparking.dto.Admin;
import com.carparking.dto.Vehicle;

public interface CheckOutViewCallback {
    void invalidMessage(String invalidOption, Admin admin);
    void gotoHome(Admin admin);
    void checkOut(Admin admin);
    void checkOutSuccess(Vehicle vehicle, Admin admin);
}