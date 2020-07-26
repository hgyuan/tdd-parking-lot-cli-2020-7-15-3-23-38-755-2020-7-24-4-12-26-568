package com.oocl.cultivation.test;

import java.util.List;

public class NotSmartParkingBoy extends ParkingBoy {
    public NotSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public List<Ticket> parkingSequence(List<Car> cars) {
        return parking(cars);
    }

    public boolean isHaveParkingLot(List<Car> cars) {
        parkingSequence(cars);
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isParking()) {
                return true;
            }
        }
        return false;
    }
}
