package com.oocl.cultivation.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ParkingLot {

    private List<Car> cars;
    private Integer maxSize;
    private List<Ticket> tickets;

    public ParkingLot() {
        maxSize = 10;
        cars = new ArrayList<>(10);
        tickets = new ArrayList<>();
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Ticket parking(Car car) {
        if (!isParking()) {
            return null;
        }
        cars.add(car);
        return createTicket(car);
    }


    public boolean isParking() {
        return maxSize > cars.size();
    }

    public Car fetch(Integer carNumber) {
        for (Car car : cars) {
            if (car.getId().equals(carNumber)) {
                cars.remove(car);
                return car;
            }
        }
        return null;
    }

    public Integer getCarSize(){
        return cars.size();
    }

    public Ticket createTicket(Car car) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String ticketId = format.format(calendar.getTime()) + Math.random() * 1000;
        Ticket ticket = new Ticket(car.getId(), ticketId);
        ticket.setCarNumber(car.getId());
        tickets.add(ticket);
        return ticket;
    }

    public String getMessageOfFetch(Ticket ticket) {
        return "";
    }
}
