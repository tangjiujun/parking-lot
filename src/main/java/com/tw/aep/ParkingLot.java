package com.tw.aep;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLot {
    private final Integer maxSlotSize;
    private final Map<Ticket, Car> parkingSlots = new HashMap<>();

    public ParkingLot(int maxSlotSize) {
        this.maxSlotSize = maxSlotSize;
    }

    public Ticket parking(Car car) {
        if (parkingSlots.size() >= maxSlotSize) {
            throw new IllegalStateException("Parking Lot is Full.");
        }
        Ticket ticket = new Ticket(car.getNo());
        parkingSlots.put(ticket, car);
        return ticket;
    }

    public Car takeout(Ticket ticket) {
        return Optional.ofNullable(parkingSlots.remove(ticket))
                .orElseThrow(() -> new IllegalStateException("Invalid ticket."));
    }

    public boolean hasSlot() {
        return parkingSlots.size() < maxSlotSize;
    }

    public boolean hasTicket(Ticket ticket) {
        return parkingSlots.containsKey(ticket);
    }

    public int getEmptySlotSize() {
        return maxSlotSize - parkingSlots.size();
    }
}
