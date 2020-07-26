package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    List<ParkingBoy> parkingBoys;
    List<ParkingLot> parkingLots;

    public ParkingManager() {
        this.parkingLots = new ArrayList<>();
        this.parkingBoys = new ArrayList<>();
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public Ticket parkingByParkingBoy(Car car) {
        for(ParkingBoy parkingBoy:parkingBoys){
            Ticket ticket = parkingBoy.parking(car);
            if(ticket!=null){
                return ticket;
            }
        }
        return null;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public Ticket parking(Car car) {
        ParkingBoy parkingBoy = new NotSmartParkingBoy();
        for(ParkingLot parkingLot:parkingLots){
            parkingBoy.addParkingLot(parkingLot);
        }
        return parkingBoy.parking(car);
    }

    public boolean isHaveFullParkingLot() {
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.getMaxSize()==parkingLot.getCarSize()){
                return true;
            }
        }
        return false;
    }

    public Car fetch(Ticket ticket) {
        ParkingBoy parkingBoy = new NotSmartParkingBoy();
        for(ParkingLot parkingLot:parkingLots){
            parkingBoy.addParkingLot(parkingLot);
        }
        return parkingBoy.fetch(ticket);
    }

    public String getMessageOfFetch(Ticket ticket) {
        return null;
    }
}
