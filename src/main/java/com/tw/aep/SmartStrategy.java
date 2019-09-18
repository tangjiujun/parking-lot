package com.tw.aep;

import java.util.List;
import java.util.Optional;

public class SmartStrategy implements ParkingStrategy {
    private final List<ParkingLot> parkingLots;

    public SmartStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket parking(Car car) {
        Optional<ParkingLot> parkingLot = parkingLots.stream().reduce((a, b) -> a.getEmptySlotSize() > b.getEmptySlotSize() ? a : b);
        return parkingLot.map(p -> p.parking(car)).orElseThrow(() -> new IllegalStateException("All parking lot is full"));
    }
}
