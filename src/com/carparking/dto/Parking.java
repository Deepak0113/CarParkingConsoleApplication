package com.carparking.dto;

public class Parking {
    private int floors;
    private int parkingCountPerFloor;
    private boolean parking[][];

    public Parking(int floors, int parkingCountPerFloor) {
        this.floors = floors;
        this.parkingCountPerFloor = parkingCountPerFloor;
        parking = new boolean[floors][parkingCountPerFloor];
    }

    public String getParking(){
        for(int i=0; i<floors; i++){
            for(int j=0; j<parkingCountPerFloor; j++){
                if(!parking[i][j]){
                    parking[i][j] = true;
                    return "F"+i+"P"+j;
                }
            }
        }

        return "";
    }

    public void emptyParking(String parkingNumber) {
        int ind = parkingNumber.indexOf('P');
        int posX = Integer.parseInt(parkingNumber.substring(1, ind));
        int posY = Integer.parseInt(parkingNumber.substring(ind+1));

        parking[posX][posY] = false;
    }
}
