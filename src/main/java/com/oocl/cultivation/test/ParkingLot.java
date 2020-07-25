package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    List<Car> cars ;

    public ParkingLot() {
        cars = new ArrayList<>();
    }

    public boolean parking(Car car) {
        cars.add(car);
        return true;
    }

    public Car fetch(Integer carNumber){
        for(Car car:cars){
            if(car.getId().equals(carNumber)){
                return car;
            }
        }
        return null;
    }
}
