package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_fifthCar_from_second_parkinglot_when_first_parkinglot_has_parked_three_Car_and_secondparkingLot_has_parking_one_Car() throws Exception {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thridCar = new Car();
        Car fourthCar = new Car();
        Car fifthCar = new Car();
        ParkingLot firstParkingLot = new ParkingLot(5);
        firstParkingLot.parkCar(firstCar);
        firstParkingLot.parkCar(secondCar);
        firstParkingLot.parkCar(thridCar);
        ParkingLot sencondParkingLot = new ParkingLot();
        sencondParkingLot.parkCar(fourthCar);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        superSmartParkingBoy.manageParkingLot(firstParkingLot);
        superSmartParkingBoy.manageParkingLot(sencondParkingLot);
        //when
        Ticket ticket = superSmartParkingBoy.parkCar(fifthCar);
        Car fetchCar = sencondParkingLot.fetchCar(ticket);
        //then
        assertSame(fifthCar,fetchCar);
    }
}
