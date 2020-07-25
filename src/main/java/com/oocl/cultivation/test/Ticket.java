package com.oocl.cultivation.test;

public class Ticket {

    private Integer carNumber;
    private Integer id;

    public Ticket(Integer carNumber, Integer id) {
        this.carNumber = carNumber;
        this.id = id;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }
}
