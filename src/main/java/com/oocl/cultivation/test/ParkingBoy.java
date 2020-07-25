package com.oocl.cultivation.test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ParkingBoy {

    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parking(Car car) {
        parkingLot.parking(car);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String ticketId = format.format(calendar.getTime())+Math.random()*1000;
        Ticket ticket = new Ticket(car.getId(),ticketId);
        ticket.setCarNumber(car.getId());
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        ticket.setUsed(true);
        return parkingLot.fetch(ticket.getCarNumber());
    }

    public List<Ticket> parking(List<Car> cars) {
        List<Ticket> tickets = new ArrayList<>();
        for(Car car :cars){
            tickets.add(parking(car));
        }
        return tickets;
    }
}
