package com.tw.aep;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParkingLotTest {
    @Test
    public void should_get_1_ticket_when_parking_1_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);

        // when
        Ticket ticket = parkingLot.parking(new Car("川A88888"));

        // then
        assertThat(ticket.getCarNo(), is("川A88888"));
    }

    @Test
    public void should_get_multi_tickets_when_parking_multi_cars() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);

        // when
        Ticket ticket1 = parkingLot.parking(new Car("川A88881"));
        Ticket ticket2 = parkingLot.parking(new Car("川A88882"));
        Ticket ticket3 = parkingLot.parking(new Car("川A88883"));

        // then
        assertThat(ticket1.getCarNo(), is("川A88881"));
        assertThat(ticket2.getCarNo(), is("川A88882"));
        assertThat(ticket3.getCarNo(), is("川A88883"));
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_when_parking_lot_is_full() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parking(new Car("川A88888"));

        // when
        parkingLot.parking(new Car("川A88881"));
    }

    @Test
    public void should_get_carNo_when_input_correct_slotNo() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.parking(new Car("川A88888"));

        // when
        Car car = parkingLot.takeout(ticket);

        // then
        assertThat(car.getNo(), is("川A88888"));
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_when_ticket_is_invalid() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.parking(new Car("川A88888"));
        parkingLot.takeout(ticket);

        // when
        parkingLot.takeout(ticket);
    }
}
