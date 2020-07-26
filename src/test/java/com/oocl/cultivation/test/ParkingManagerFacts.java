package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingManagerFacts {
    @Test
    void should_have_parking_boy_when_add_parking_boy_given_parking_boy_parking_manager() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        parkingManager.addParkingBoy(parkingBoy);

        //then
        assertEquals(1,parkingManager.getParkingBoys().size());

    }

    @Test
    void should_return_ticket_when_parking_by_parking_boy_given_car_parking_boy_parking_manager_parking_lot() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingManager.addParkingBoy(parkingBoy);
        Car car = new Car(1);

        //when
        Ticket ticket = parkingManager.parkingByParkingBoy(car);

        //then
        assertEquals(car.getId(),ticket.getCarNumber());
    }
}
