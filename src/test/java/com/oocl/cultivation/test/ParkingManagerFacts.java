package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void should_return_ticket_when_parking_given_car_parking_manager_parking_lot() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot();
        parkingManager.addParkingLot(parkingLot);
        Car car = new Car(1);

        //when
        Ticket ticket = parkingManager.parking(car);

        //then
        assertEquals(car.getId(),ticket.getCarNumber());

    }

    @Test
    void should_return_true_when_have_full_parking_lot_given_parking_lot_max_size_car_2parking_lot() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot();
        ParkingLot parkingLotTwo = new ParkingLot();
        parkingManager.addParkingLot(parkingLot);
        parkingManager.addParkingLot(parkingLotTwo);
        for(int i=0;i<parkingLot.getMaxSize();i++){
            parkingManager.parking(new Car(i));
        }

        //when
        boolean result = parkingManager.isHaveFullParkingLot();

        //then
        assertTrue(result);
    }

    @Test
    void should_return_car_when_fetch_given_ticket_parking_manager_parking_lot() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(1);
        Ticket ticket = new Ticket(1,"1");
        ticket.setParkingLot(parkingLot);
        parkingManager.addParkingLot(parkingLot);
        parkingManager.parking(car);

        //when
        Car resultCar = parkingManager.fetch(ticket);

        //then
        assertEquals(car,resultCar);
    }
}
