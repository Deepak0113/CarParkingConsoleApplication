package com.carparking.home;

import com.carparking.dto.Admin;
import com.carparking.utility.Validation;

public class HomeController implements HomeViewControllerCallback, HomeModelControllerCallback {
    private HomeViewCallback homeView;
    private HomeModelCallback homeModel;

    HomeController(HomeViewCallback homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel(this);
    }

    @Override
    public void chooseOption(String option, Admin admin) {
        if(!Validation.validateOption(option)){
            homeView.invalidMessage("Invalid option", admin);
        } else{
            switch (option){
                case "1" -> homeView.gotoCheckIn(admin);
                case "2" -> homeView.gotoCheckOut(admin);
                case "3" -> homeView.logout(admin);
                case "9" -> System.exit(0);
            }
        }
    }

    @Override
    public void logoutAdmin(Admin admin) {
        homeModel.logoutAdmin(admin);
    }
}