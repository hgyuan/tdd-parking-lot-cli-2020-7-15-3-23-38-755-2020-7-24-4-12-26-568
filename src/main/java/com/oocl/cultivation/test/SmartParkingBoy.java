package com.oocl.cultivation.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);

    }

    @Override
    public Ticket parking(Car car) {
        return this.parking(car);
    }

    private Ticket smartParking(Car car){
        ParkingLot usedParkingLot = null;
        Integer currentMinSize = Integer.MAX_VALUE;
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.getCarSize()<=currentMinSize){
                currentMinSize = parkingLot.getCarSize();
                usedParkingLot=parkingLot;
            }
        }
        usedParkingLot.parking(car);
        return usedParkingLot.createTicket(car);
    }

    public List<Ticket> smartParking(List<Car> cars) {
        List<Ticket> tickets = new ArrayList<>();
        for(Car car :cars){
            tickets.add(smartParking(car));
        }
        return tickets;
    }

    public boolean isSmartParking() {
        for(ParkingLot parkingLotFirst:parkingLots){
            for(ParkingLot parkingLotSecond:parkingLots){
                if(Math.abs(parkingLotFirst.getCarSize()-parkingLotSecond.getCarSize())>1){
                    return false;
                }
            }
        }
        return true;
    }
}
