package com.carparking.dto;

import java.util.ArrayList;
import java.util.List;

public class Admin{
    private String adminId;
    private String adminName;
    private List<TimeShift> shifts;

    public Admin(String adminId, String adminName) {
        this.adminId = adminId;
        this.adminName = adminName;
        shifts = new ArrayList<>();
    }

    public String getAdminName() {
        return adminName;
    }

    public List<TimeShift> getShifts() {
        return shifts;
    }

    public void setShifts(List<TimeShift> shifts) {
        this.shifts = shifts;
    }
}
