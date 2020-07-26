package com.oocl.cultivation.test;


import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public Ticket parking(Car car) {
        return this.parking(car);
    }

    private Ticket superSmartParking(Car car){
        ParkingLot usedParkingLot = null;
        Double current = 1.0;
        for(ParkingLot parkingLot:parkingLots){
            if(1.0*parkingLot.getCarSize()/parkingLot.getMaxSize()<current){
                current = 1.0*parkingLot.getCarSize()/parkingLot.getMaxSize();
                usedParkingLot = parkingLot;
            }
        }
        assert usedParkingLot != null;
        return usedParkingLot.parking(car);
    }

    public List<Ticket> superSmartParking(List<Car> cars) {
        List<Ticket> tickets = new ArrayList<>();
        for(Car car:cars){
            tickets.add(superSmartParking(car));
        }
        return tickets;
    }

    public boolean isSuperSmartParking() {
        for(ParkingLot parkingLot:parkingLots){
            for(ParkingLot parkingLotSecond:parkingLots){
                int firstSize = parkingLot.getMaxSize();
                int firstCarSize = parkingLot.getCarSize();
                int secondSize = parkingLotSecond.getMaxSize();
                int secondCarSize = parkingLotSecond.getCarSize();
                double current = (1.0*firstCarSize/firstSize)/(1.0*secondCarSize/secondSize);
                if(firstCarSize>0&&secondCarSize>0){
                    if(firstCarSize>secondCarSize){
                        if(1.0*(firstCarSize-1)/firstSize<1.0*(secondCarSize)/secondSize){
                            return false;
                        }
                    }
                    if(firstCarSize<secondCarSize){
                        if(1.0*(firstCarSize)/firstSize<1.0*(secondCarSize-1)/secondSize){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
