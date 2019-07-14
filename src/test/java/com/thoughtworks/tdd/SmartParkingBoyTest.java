package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartParkingBoyTest {
    @Test
    public void should_return_secondCar_from_second_parkinglot_when_first_parkinglot_has_parking_one_Car_and_secondparkingLot_is_empty() throws Exception {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot sencondParkingLot = new ParkingLot();
        ParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.manageParkingLot(firstParkingLot);
        smartParkingBoy.manageParkingLot(sencondParkingLot);
        //when
        smartParkingBoy.parkCar(firstCar);
        Ticket secondTicket = smartParkingBoy.parkCar(secondCar);
        Car fetchCar = sencondParkingLot.fetchCar(secondTicket);
        //then
        assertSame(secondCar,fetchCar);
    }
}
