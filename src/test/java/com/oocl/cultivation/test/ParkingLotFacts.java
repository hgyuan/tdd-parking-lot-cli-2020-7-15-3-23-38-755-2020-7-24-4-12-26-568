package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @Test
    void should_return_car_when_fetch_given_ticket() {
        //given
        Ticket ticket = new Ticket(1,"1");
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.parking(car);

        //when
        Car resultCar = parkingLot.fetch(ticket);

        //then
        assertEquals(car,resultCar);

    }

    @Test
    void should_return_unrecognized_parking_ticket_when_get_message_of_fetch_given_wrong_ticket_parking_lot() {
        //given
        Ticket ticket = new Ticket(12, "1");
        ParkingLot parkingLot = new ParkingLot();

        //when
        boolean message = parkingLot.isUnusedMyCurrentTicket(ticket);

        //then
        assertFalse(message);
    }


}
