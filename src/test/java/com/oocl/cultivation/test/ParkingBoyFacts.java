package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingBoyFacts {

    @Test
    void should_return_ticket_when_parking_given_car_boy_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(1);
        Boy boy = new Boy();

        //when
        Ticket ticket = boy.parking(car,parkingLot);

        //then
        assertEquals(car.getId(),ticket.getClassNumber());

    }
}
