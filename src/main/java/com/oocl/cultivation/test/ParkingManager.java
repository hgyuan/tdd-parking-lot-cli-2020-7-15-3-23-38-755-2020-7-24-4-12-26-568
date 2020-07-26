package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    List<ParkingBoy> parkingBoys;

    public ParkingManager() {
        this.parkingBoys = new ArrayList<>();
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public Ticket parkingByParkingBoy(Car car) {
        return null;
    }
}
