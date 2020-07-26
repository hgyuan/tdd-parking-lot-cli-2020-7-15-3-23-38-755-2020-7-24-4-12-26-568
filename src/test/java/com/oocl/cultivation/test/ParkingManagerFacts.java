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


    @Test
    void should_return_please_provide_your_parking_ticket_when_get_message_of_fetch_given_null_ticket_parking_manager_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.addParkingLot(parkingLot);

        //when
        String message = parkingManager.getMessageOfFetch(null);

        //then
        assertEquals("Please provide your parking ticket", message);
    }


    @Test
    void should_return_unrecognized_parking_ticket_when_get_message_of_fetch_given_wrong_ticket_parking_manager_parking_lot() {
        //given
        Ticket ticket = new Ticket(12, "1");
        ParkingLot parkingLot = new ParkingLot();
        ticket.setParkingLot(null);
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.addParkingLot(parkingLot);

        //when
        String message = parkingManager.getMessageOfFetch(ticket);

        //then
        assertEquals("Unrecognized parking ticket", message);
    }

    @Test
    void should_return_not_enough_position_when_get_message_of_parking_given_car_parking_manager_full_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingManager parkingManager = new ParkingManager();
        for (int i = 0; i < 10; i++) {
            parkingManager.parking(new Car(i));
        }
        Car car = new Car(11);

        //when
        String message = parkingManager.getMessageOfParking(car);

        //then
        assertEquals("Not enough position", message);
    }

}
