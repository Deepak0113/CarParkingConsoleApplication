package com.carparking.repository;

import com.carparking.dto.*;
import com.carparking.statuscalls.LoginStatusCall;
import com.carparking.statuscalls.ParkingStatusCall;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Repository {
    private static Repository repository;
    private HashMap<String, Credential> credentialTable;
    private HashMap<String, Vehicle> vehicleTable;
    private Parking parking;

    public static Repository getInstance(){
        if(repository == null){
            repository = new Repository();
            repository.initSetup();
        }

        return repository;
    }

    /*------ INITIALISE SETUP ------*/
    private void initSetup(){
        credentialTable = new HashMap<>();
        vehicleTable = new HashMap<>();
        credentialTable.put("admin1", new Credential("admin1", "Deepak", "admin123"));
        parking = new Parking(1, 10);
    }

    /*------ ADMIN LOGIN ------*/
    public LoginStatusCall login(String adminId, String password){
        if(!credentialTable.containsKey(adminId)){
            return new LoginStatusCall("NOT EXIST");
        }

        Credential credential = credentialTable.get(adminId);

        if(!credential.getPassword().equals(password)){
            return new LoginStatusCall("INCORRECT PASSWORD");
        }

        Admin admin = credential;
        List<TimeShift> shiftList = admin.getShifts();
        shiftList.add(new TimeShift(LocalDateTime.now()));
        admin.setShifts(shiftList);
        return new LoginStatusCall("SUCCESS", admin);
    }

    public void logout(Admin admin) {
        List<TimeShift> shiftList = admin.getShifts();
        TimeShift shift = shiftList.get(shiftList.size()-1);
        shift.setEndLocalDateTime(LocalDateTime.now());
        admin.setShifts(shiftList);
    }
    
    public ParkingStatusCall checkInCar(String carNumber, String carName, String carType) {
        String parkingPosition = parking.getParking();

        if(parkingPosition.equals(""))
            return new ParkingStatusCall("FULL");

        if(vehicleTable.containsKey(carNumber))
            return new ParkingStatusCall("EXIST");

        Vehicle vehicle = new Vehicle(
                carNumber,
                carName,
                carType,
                parkingPosition,
                LocalDateTime.now()
        );
        vehicleTable.put(carNumber, vehicle);

        return new ParkingStatusCall("PARKED", parkingPosition);
    }

    public ParkingStatusCall checkOutCar(String carNumber) {
        if(!vehicleTable.containsKey(carNumber))
            return new ParkingStatusCall("NOT EXIST");

        Vehicle vehicle = vehicleTable.get(carNumber);
        vehicle.setTo(LocalDateTime.now());
        parking.emptyParking(vehicle.getParkingNumber());
        vehicleTable.remove(vehicle);

        return new ParkingStatusCall("SUCCESS", vehicle);
    }
}
