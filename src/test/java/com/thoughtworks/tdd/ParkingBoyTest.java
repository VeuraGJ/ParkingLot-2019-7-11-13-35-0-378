package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingBoyTest {
    @Test
    public void should_return_car_when_give_ticket() throws Exception {
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
    public void should_fetch_multiple_car_when_give_multiple_ticket() throws Exception {
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
    @Test
    public void should_fetch_no_car_when_give_wrong_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        Ticket wrongTicket = new Ticket();
        //then
        Assertions.assertThrows(Exception.class,()->{
            parkingBoy.fetchCar(wrongTicket);
        });
    }
    @Test
    public void should_fetch_no_car_when_give_used_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(ticket);
        Ticket usedTicket = ticket;
        //then
        Assertions.assertThrows(Exception.class,()->{
            parkingBoy.fetchCar(usedTicket);
        });
    }
    @Test
    public void should_not_park_car_when_parkinglot_has_no_position() throws Exception {
        //given
        Car eleventhCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        for(int i = 0;i < 10;i++){
            Car car = new Car();
            parkingBoy.parkCar(car);
        }
        //then
        Assertions.assertThrows(Exception.class,()->{
            parkingBoy.parkCar(eleventhCar);
        });
    }
    @Test
    public void should_return_unrecognized_parking_ticket_when_give_wrong_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        String exceptedMessage = "Unrecognized parking ticket.";
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        Ticket wrongTicket = new Ticket();
        //then
        try {
            parkingBoy.fetchCar(wrongTicket);
        } catch (Exception e) {
            String message = parkingBoy.responseMessge();
            assertSame(exceptedMessage,message);
        }
    }
    @Test
    public void should_return_unrecognized_parking_ticket_when_give_used_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        String exceptedMessage = "Unrecognized parking ticket.";
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(ticket);
        Ticket usedTicket = ticket;
        //then
        try {
            parkingBoy.fetchCar(usedTicket);
        } catch (Exception e) {
            String message = parkingBoy.responseMessge();
            assertSame(exceptedMessage,message);
        }
    }
}
