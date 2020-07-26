package com.oocl.cultivation.test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ParkingBoy {

    List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
    }

    public boolean isAllFullParkingLot() {
        boolean isAllFullParkingLot = true;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isParking()) {
                isAllFullParkingLot = false;
            }
        }
        return isAllFullParkingLot;
    }

    protected Ticket createTicket(Car car){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String ticketId = format.format(calendar.getTime()) + Math.random() * 1000;
        Ticket ticket = new Ticket(car.getId(), ticketId);
        ticket.setCarNumber(car.getId());
        return ticket;
    }

    public Ticket parking(Car car) {
        if (isAllFullParkingLot()) {
            return null;
        }
        Ticket ticket =null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isParking()) {
                ticket = parkingLot.parking(car);
                break;
            }
        }
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null) {
            return null;
        }
        ticket.setUsed(true);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isParking()) {
                return parkingLot.fetch(ticket.getCarNumber());
            }
        }
        return null;
    }

    public List<Ticket> parking(List<Car> cars) {
        List<Ticket> tickets = new ArrayList<>();
        for (Car car : cars) {
            tickets.add(parking(car));
        }
        return tickets;
    }

    public String getMessageOfFetch(Ticket ticket) {
        String isCorrect="";
        String current =null;
        for(ParkingLot parkingLot:parkingLots){
            current = parkingLot.getMessageOfFetch(ticket);
            if(parkingLot.getMessageOfFetch(ticket).equals("")){
                return "";
            }
        }
        return current;
    }

    public String getMessageOfParking(Car car) {
        boolean isAllFullParkingLot = isAllFullParkingLot();
        if (isAllFullParkingLot) {
            return "Not enough position";
        }
        return "";
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
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
