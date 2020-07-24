package com.oocl.cultivation.test;


public class Boy {

    ParkingLot parkingLot;

    public Boy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parking(Car car) {
        parkingLot.parking(car);
        Ticket ticket = new Ticket();
        ticket.setClassNumber(car.getId());
        return ticket;
    }
}
