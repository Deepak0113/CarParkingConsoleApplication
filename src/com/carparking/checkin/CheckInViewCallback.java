package com.carparking.checkin;

import com.carparking.dto.Admin;

public interface CheckInViewCallback {
    void invalidMessage(String invalidOption, Admin admin);
    void checkIn(Admin admin);
    void gotoHome(Admin admin);
    void parkedSuccess(Admin admin, String vehicle);
}