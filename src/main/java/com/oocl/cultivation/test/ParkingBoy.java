package com.oocl.cultivation.test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ParkingBoy {

    List<ParkingLot> parkingLots;
    List<Ticket> tickets;

    public ParkingBoy(ParkingLot parkingLot) {
        parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        tickets = new ArrayList<>();
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Ticket parking(Car car) {
        boolean isFullParkingLot = true;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isParking()) {
                parkingLot.parking(car);
                isFullParkingLot = false;
                break;
            }
        }
        if (isFullParkingLot) {
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
        if (ticket == null) {
            return null;
        }
        ticket.setUsed(true);
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.isParking()){
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
        if (ticket == null) {
            return "Please provide your parking ticket";
        }
        if (!tickets.contains(ticket) || ticket.isUsed()) {
            return "Unrecognized parking ticket";
        }
        return "";
    }

    public String getMessageOfParking(Car car) {
        boolean isAllFullParkingLot = true;
        for(ParkingLot parkingLot:parkingLots){
            if (parkingLot.getCars().size() < parkingLot.getMaxSize()) {
                isAllFullParkingLot = false;
            }
        }
        if(isAllFullParkingLot){
            return "Not enough position";
        }

        return "";
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }


    public List<Ticket> parkingSequence(List<Car> cars) {
        return new ArrayList<>(0);
    }
}
