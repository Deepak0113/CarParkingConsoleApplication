package com.carparking.statuscalls;

import com.carparking.dto.Vehicle;

public class ParkingStatusCall extends Status{
    private Vehicle vehicle;
    private String parkingNumber;

    public ParkingStatusCall(String status){
        super(status);
    }

    public ParkingStatusCall(String status, Vehicle vehicle){
        super(status);
        this.vehicle = vehicle;
    }

    public ParkingStatusCall(String status, String parkingNumber) {
        super(status);
        this.parkingNumber = parkingNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }
}
