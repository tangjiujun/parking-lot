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

    @Test
    public void should_takeout_1_car_when_parking_lot_had_parking_my_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        int slotNo = parkingLot.parking("川A88888");

        // when
        String carNo = parkingLot.takeout(slotNo);

        // then
        assertThat(carNo, is("川A88888"));
    }
}
