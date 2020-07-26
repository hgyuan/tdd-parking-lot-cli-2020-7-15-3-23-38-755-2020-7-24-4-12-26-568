package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotSmartParkingBoyFacts {

    @Test
    void should_return_ticket_when_parking_11car_2parking_lot_parking_boy() {
        //given
        ParkingLot parkingLotOne = new ParkingLot();
        ParkingLot parkingLotTwo = new ParkingLot();
        NotSmartParkingBoy notSmartParkingBoy = new NotSmartParkingBoy(parkingLotOne);
        notSmartParkingBoy.addParkingLot(parkingLotOne);
        notSmartParkingBoy.addParkingLot(parkingLotTwo);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            cars.add(new Car(i));
        }

        //when
        List<Ticket> tickets = notSmartParkingBoy.parkingSequence(cars);

        //then
        assertEquals(11,tickets.size());
    }

    @Test
    void should_return_true_when_is_have_parking_lot_full_given_10car_2parking_lot_parking_boy() {
        //given
        ParkingLot parkingLotOne = new ParkingLot();
        ParkingLot parkingLotTwo = new ParkingLot();
        NotSmartParkingBoy notSmartParkingBoy = new NotSmartParkingBoy(parkingLotOne);
        notSmartParkingBoy.addParkingLot(parkingLotOne);
        notSmartParkingBoy.addParkingLot(parkingLotTwo);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car(i));
        }

        //when
        boolean result = notSmartParkingBoy.isHaveParkingLot(cars);

        //then
        assertTrue(result);
    }
}
