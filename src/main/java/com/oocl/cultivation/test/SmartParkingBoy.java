package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy {

    List<ParkingLot> parkingLots ;

    public SmartParkingBoy(ParkingLot parkingLot) {
        parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public List<Ticket> smartParking(List<Car> cars) {
        return null;
    }

    public boolean isSmartParking() {
        return false;
    }
}
