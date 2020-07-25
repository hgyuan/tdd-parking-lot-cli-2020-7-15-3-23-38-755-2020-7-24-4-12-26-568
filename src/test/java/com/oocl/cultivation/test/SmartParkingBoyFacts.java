package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyFacts extends ParkingBoyFacts {

    @Test
    void should_return_true_when_is_Smart_Parking_given_11car_2parking_lot_parking_boy() {
        //given
        ParkingLot parkingLotOne = new ParkingLot();
        ParkingLot parkingLotTwo = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotOne);
        smartParkingBoy.addParkingLot(parkingLotTwo);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            cars.add(new Car(i));
        }
        smartParkingBoy.smartParking(cars);

        //when
        boolean result = smartParkingBoy.isSmartParking();

        //then
        assertTrue(result);
    }
}
