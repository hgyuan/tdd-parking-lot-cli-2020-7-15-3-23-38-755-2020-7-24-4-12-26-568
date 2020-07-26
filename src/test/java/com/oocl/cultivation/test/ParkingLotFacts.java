package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotFacts {

    @Test
    void should_ticket_when_create_ticket_given_car_parking_lot() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket ticket = parkingLot.createTicket(car);

        //then
        assertEquals(car.getId(),ticket.getCarNumber());
    }

    @Test
    void should_return_ticket_when_parking_given_car_parking_lot() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket ticket = parkingLot.parking(car);

        //then
        assertEquals(car.getId(),ticket.getCarNumber());
    }
}
