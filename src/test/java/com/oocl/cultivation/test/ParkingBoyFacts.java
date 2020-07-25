package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {

    @Test
    void should_return_ticket_when_parking_given_car_boy_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(car);

        //then
        assertEquals(car.getId(), ticket.getCarNumber());
    }

    @Test
    void should_return_car_when_fetch_given_parking_boy_parking_lot_ticket_a_car_in_parking_lot() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.parking(car);
        Ticket ticket = new Ticket(1, "1");

        //when
        Car returnCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, returnCar);

    }

    @Test
    void should_return_2_ticket_when_parking_given_two_car_parking_boy_parking_lot() {
        Car firstCar = new Car(1);
        Car secondCar = new Car(2);
        List<Car> cars = new ArrayList<>();
        cars.add(firstCar);
        cars.add(secondCar);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        List<Ticket> tickets = parkingBoy.parking(cars);

        //then
        assertEquals(cars.size(), tickets.size());
    }

    @Test
    void should_return_null_when_fetch_given_wrong_ticket_parking_boy_parking_lot() {
        //given
        Ticket ticket = new Ticket(12, "1");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Car wrongTicketCar = parkingBoy.fetch(ticket);
        Car nullTicketCar = parkingBoy.fetch(null);

        //then
        assertNull(wrongTicketCar);
        assertNull(nullTicketCar);

    }

    @Test
    void should_return_null_when_fetch_given_used_ticket_parking_boy_parking_lot() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.parking(car);
        parkingBoy.fetch(ticket);

        //when
        Car fetchCar = parkingBoy.fetch(ticket);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_null_when_parking_given_full_parking_lot_parking_boy_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parking(new Car(i));
        }
        Car car = new Car(11);

        //when
        Ticket ticket = parkingBoy.parking(car);

        //then
        assertNull(ticket);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_get_message_of_fetch_given_wrong_ticket_parking_boy_parking_lot() {
        //given
        Ticket ticket = new Ticket(12, "1");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        String message = parkingBoy.getMessageOfFetch(ticket);

        //then
        assertEquals("Unrecognized parking ticket",message);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_get_message_of_fetch_given_null_ticket_parking_boy_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        String message = parkingBoy.getMessageOfFetch(null);

        //then
        assertEquals("Please provide your parking ticket",message);
    }
}
