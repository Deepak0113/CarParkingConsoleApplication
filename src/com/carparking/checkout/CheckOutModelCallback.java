package com.carparking.checkout;

import com.carparking.dto.Admin;

public interface CheckOutModelCallback {
    void checkOutCar(Admin admin, String carNumber);
}