package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Car> cars;
    private Integer maxSize;

    public ParkingLot() {
        maxSize = 10;
        cars = new ArrayList<>(10);
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public boolean parking(Car car) {
        if (!isParking()) {
            return false;
        }
        cars.add(car);
        return true;
    }

    public boolean isParking() {
        return maxSize > cars.size();
    }

    public Car fetch(Integer carNumber) {
        for (Car car : cars) {
            if (car.getId().equals(carNumber)) {
                cars.remove(car);
                return car;
            }
        }
        return null;
    }

    public Integer getCarSize(){
        return cars.size();
    }
}
