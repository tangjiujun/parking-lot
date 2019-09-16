package com.tw.parkinglot;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParkingLotTest {
    @Test
    public void should_parking_1_car_when_parking_lot_is_empty() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);

        // when
        int slotNo = parkingLot.parking("川A88888");

        // then
        assertThat(slotNo, is(1));
    }
}
