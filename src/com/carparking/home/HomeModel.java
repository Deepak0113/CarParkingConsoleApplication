package com.carparking.home;

import com.carparking.dto.Admin;
import com.carparking.repository.Repository;

public class HomeModel implements HomeModelCallback {
    HomeModelControllerCallback homeController;

    HomeModel(HomeModelControllerCallback homeController) {
        this.homeController = homeController;
    }

    @Override
    public void logoutAdmin(Admin admin) {
        Repository.getInstance().logout(admin);
    }
}