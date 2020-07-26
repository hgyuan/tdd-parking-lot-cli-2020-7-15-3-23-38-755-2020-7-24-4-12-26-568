package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    List<ParkingBoy> parkingBoys;
    List<ParkingLot> parkingLots;

    public ParkingManager() {
        this.parkingLots = new ArrayList<>();
        this.parkingBoys = new ArrayList<>();
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public Ticket parkingByParkingBoy(Car car) {
        for(ParkingBoy parkingBoy:parkingBoys){
            Ticket ticket = parkingBoy.parking(car);
            if(ticket!=null){
                return ticket;
            }
        }
        return null;
    }

    public void addParkingLot(ParkingLot parkingLot) {
    }

    public Ticket parking(Car car) {
        return null;
    }
}
