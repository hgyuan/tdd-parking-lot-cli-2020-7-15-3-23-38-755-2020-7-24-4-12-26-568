package com.oocl.cultivation.test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ParkingBoy {

    ParkingLot parkingLot;
    List<Ticket> tickets ;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        tickets = new ArrayList<>();
    }

    public Ticket parking(Car car) {
        if (!parkingLot.parking(car)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String ticketId = format.format(calendar.getTime()) + Math.random() * 1000;
        Ticket ticket = new Ticket(car.getId(), ticketId);
        ticket.setCarNumber(car.getId());
        tickets.add(ticket);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if(ticket==null){
            return null;
        }
        ticket.setUsed(true);
        return parkingLot.fetch(ticket.getCarNumber());
    }

    public List<Ticket> parking(List<Car> cars) {
        List<Ticket> tickets = new ArrayList<>();
        for (Car car : cars) {
            tickets.add(parking(car));
        }
        return tickets;
    }

    public String getMessageOfFetch(Ticket ticket) {
        if(ticket==null){
            return "Please provide your parking ticket";
        }
        if(!tickets.contains(ticket)||ticket.isUsed()){
            return "Unrecognized parking ticket";
        }
        return "";
    }

    public String getMessageOfParking(Car car) {
        return "";
    }
}
