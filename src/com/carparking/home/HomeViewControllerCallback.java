package com.carparking.home;

import com.carparking.dto.Admin;

public interface HomeViewControllerCallback {
    void chooseOption(String option, Admin admin);

    void logoutAdmin(Admin admin);
}
