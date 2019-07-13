package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingBoyTest {
    @Test
    public void should_return_car_when_give_ticket(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        Car fetchCar = parkingBoy.fetchCar(ticket);
        //then
        assertSame(car,fetchCar);
    }
    @Test
    public void should_fetch_multiple_car_when_give_multiple_ticket(){
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket firstTicket = parkingBoy.parkCar(firstCar);
        Ticket secondTicket = parkingBoy.parkCar(secondCar);
        Car fetchFirstCar = parkingBoy.fetchCar(firstTicket);
        Car fetchSecondCar = parkingBoy.fetchCar(secondTicket);
        //then
        assertSame(firstCar,fetchFirstCar);
        assertSame(secondCar,fetchSecondCar);
    }
}
