package com.carparking.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vehicle {
    private String numberPlate;
    private String name;
    private String type;
    private String parkingNumber;
    private LocalDateTime from;
    private LocalDateTime to;
    private float cost;
    private int costPerMin = 80;

    public Vehicle(String numberPlate, String name, String type, String parkingNumber, LocalDateTime from) {
        this.numberPlate = numberPlate;
        this.name = name;
        this.type = type;
        this.parkingNumber = parkingNumber;
        this.from = from;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
        int mins = (int) Duration.between(from, to).getSeconds() / 60;
        this.cost = mins * costPerMin;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String res = "Number plate: " + numberPlate + "\n";
        res += "Name: " + name + "\n";
        res += "Type: " + type + "\n";
        res += "Parking Number: " + parkingNumber + "\n";
        res += "From: " + from.format(formatter) + "\n";
        res += "To: " + to.format(formatter) + "\n";
        res += "Cost: " + cost + "\n";

        return res;
    }
}
