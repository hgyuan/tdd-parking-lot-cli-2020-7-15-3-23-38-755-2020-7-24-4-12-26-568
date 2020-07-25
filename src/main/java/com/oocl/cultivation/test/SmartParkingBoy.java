package com.oocl.cultivation.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);

    }

    public Ticket smartParking(Car car){
        ParkingLot usedParkingLot = null;
        Integer currentMinSize = Integer.MAX_VALUE;
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.getCarSize()<=currentMinSize){
                currentMinSize = parkingLot.getCarSize();
                usedParkingLot=parkingLot;
            }
        }
        usedParkingLot.parking(car);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String ticketId = format.format(calendar.getTime()) + Math.random() * 1000;
        Ticket ticket = new Ticket(car.getId(), ticketId);
        ticket.setCarNumber(car.getId());
        tickets.add(ticket);
        return ticket;
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
