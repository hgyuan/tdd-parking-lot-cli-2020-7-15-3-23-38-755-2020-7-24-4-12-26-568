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

    public ParkingBoy(){
        parkingLots = new ArrayList<>();
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

    public List<Ticket> parking(List<Car> cars) {
        List<Ticket> tickets = new ArrayList<>();
        for (Car car : cars) {
            tickets.add(parking(car));
        }
        return tickets;
    }

    public Car fetch(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if(ticket!=null&&ticket.getParkingLot()==parkingLot){
                return parkingLot.fetch(ticket);
            }
        }
        return null;
    }

    public String getMessageOfFetch(Ticket ticket) {
        if (ticket == null) {
            return Message.NULLTICKETE;
        }
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.isUnusedMyCurrentTicket(ticket)){
                return "";
            }
        }
        return Message.WRONGTICKETE;
    }

    public String getMessageOfParking(Car car)  {
        boolean isAllFullParkingLot = isAllFullParkingLot();
        if (isAllFullParkingLot) {
            return Message.NOTENOUGHPOSITION;
        }
        return "";
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }


}
