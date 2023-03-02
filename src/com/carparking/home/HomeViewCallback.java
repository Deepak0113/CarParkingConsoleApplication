package com.carparking.home;

import com.carparking.dto.Admin;

public interface HomeViewCallback {
    void invalidMessage(String invalidOption, Admin admin);
    void gotoCheckIn(Admin admin);
    void gotoCheckOut(Admin admin);
    void logout(Admin admin);
}