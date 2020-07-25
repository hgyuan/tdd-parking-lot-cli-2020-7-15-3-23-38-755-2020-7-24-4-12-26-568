package com.oocl.cultivation.test;


public class ParkingBoy {

    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parking(Car car) {
        parkingLot.parking(car);
        Ticket ticket = new Ticket(car.getId(),1);
        ticket.setCarNumber(car.getId());
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return parkingLot.fetch(ticket.getCarNumber());
    }
}
