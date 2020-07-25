package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Ticket ticket = new Ticket(1, 1);

        //when
        Car returnCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car,returnCar);

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
        assertEquals(cars.size(),tickets.size());
    }
}
