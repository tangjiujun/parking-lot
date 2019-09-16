package com.tw.parkinglot;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParkingLot {
    private final Stack<Integer> availableSlots = new Stack<>();
    private final Map<Integer, String> parkingSlots = new HashMap<>();

    public ParkingLot(int maxSlotSize) {
        for (int i = maxSlotSize; i > 0; i--) {
            this.availableSlots.add(i);
        }
    }

    public int parking(String carNo) {
        Integer slotNo;
        try {
            slotNo = availableSlots.pop();
        } catch (EmptyStackException e) {
            throw new IllegalStateException("Parking Lot is Full.");
        }
        parkingSlots.put(slotNo, carNo);
        return slotNo;
    }

    public String takeout(int slotNo) {
        return parkingSlots.get(slotNo);
    }
}
