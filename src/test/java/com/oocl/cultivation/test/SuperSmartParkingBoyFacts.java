package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyFacts {

    @Test
    void should_return_true_when_super_smart_parking_given_11car_2parking_lot_super_smart_parking_boy() {
        //given
        ParkingLot parkingLotOne = new ParkingLot();
        ParkingLot parkingLotTwo = new ParkingLot();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotOne);
        superSmartParkingBoy.addParkingLot(parkingLotTwo);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            cars.add(new Car(i));
        }
        superSmartParkingBoy.superSmartParking(cars);

        //when
        boolean result =superSmartParkingBoy.isSuperSmartParking();

        //then
        assertTrue(result);
    }
}
