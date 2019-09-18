package com.tw.aep;

import java.util.List;

public class OrderStrategy implements ParkingStrategy {
    private final List<ParkingLot> parkingLots;

    public OrderStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket parking(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasSlot()) {
                return parkingLot.parking(car);
            }
        }
        throw new IllegalStateException("All Parking Lot is full");
    }
}
