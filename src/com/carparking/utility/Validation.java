package com.carparking.utility;

public class Validation {
    public static boolean validateOption(String option){
        String regex = "[0-9]";
        return option.matches(regex);
    }
}
