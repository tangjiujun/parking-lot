package com.tw.parkinglot;

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
        Integer slotNo = availableSlots.pop();
        parkingSlots.put(slotNo, carNo);
        return slotNo;
    }

    public String takeout(int slotNo) {
        return parkingSlots.get(slotNo);
    }
}
