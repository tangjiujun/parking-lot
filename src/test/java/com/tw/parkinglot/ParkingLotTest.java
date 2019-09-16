package com.tw.parkinglot;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParkingLotTest {
    @Test
    public void should_get_1_ticket_when_parking_1_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);

        // when
        int slotNo = parkingLot.parking("川A88888");

        // then
        assertThat(slotNo, is(1));
    }

    @Test
    public void should_get_multi_tickets_when_parking_multi_cars() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);

        // when
        int slotNo1 = parkingLot.parking("川A88881");
        int slotNo2 = parkingLot.parking("川A88882");
        int slotNo3 = parkingLot.parking("川A88883");

        // then
        assertThat(slotNo1, is(1));
        assertThat(slotNo2, is(2));
        assertThat(slotNo3, is(3));
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_when_parking_lot_is_full() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parking("川A88888");

        // when
        parkingLot.parking("川A88881");
    }

    @Test
    public void should_get_carNo_when_input_correct_slotNo() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        int slotNo = parkingLot.parking("川A88888");

        // when
        String carNo = parkingLot.takeout(slotNo);

        // then
        assertThat(carNo, is("川A88888"));
    }
}
