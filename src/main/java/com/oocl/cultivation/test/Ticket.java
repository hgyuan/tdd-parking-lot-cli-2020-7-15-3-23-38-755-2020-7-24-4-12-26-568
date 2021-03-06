package com.oocl.cultivation.test;

public class Ticket {

    private Integer carNumber;
    private String id;
    private boolean used;
    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket(Integer carNumber, String id) {
        this.carNumber = carNumber;
        this.id = id;
        used = false;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }
}
