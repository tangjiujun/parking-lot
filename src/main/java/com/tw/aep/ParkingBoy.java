package com.tw.aep;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private final ParkingStrategy parkingStrategy;

    public ParkingBoy(List<ParkingLot> parkingLots, ParkingStrategy parkingStrategy) {
        this.parkingLots = parkingLots;
        this.parkingStrategy = parkingStrategy;
    }

    public Ticket parking(Car car) {
        return parkingStrategy.parking(car);
    }

    public Car takeout(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasTicket(ticket)) {
                return parkingLot.takeout(ticket);
            }
        }
        throw new IllegalStateException("All Parking Lot invalid ticket");
    }
}
