package com.carparking.checkin;

import com.carparking.dto.Admin;

public interface CheckInModelControllerCallback {
    void parkedSuccess(Admin admin, String vehicle);
    void invalidMessage(String message, Admin admin);
}
