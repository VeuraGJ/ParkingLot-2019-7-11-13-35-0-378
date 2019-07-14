package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ManagerTest {
    @Test
    public void should_return_car_when_specify_parkingboy_to_park_car() throws Exception {
        //give
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        Manager manager = new Manager(parkingLotList);
        //when
        manager.manageParkingBoy(parkingBoy,parkingLotList);
        manager.setParkable(parkingBoy);
        Ticket ticket = manager.specifyParkingBoyParkCar(car);
        Car fetchCar = parkingBoy.fetchCar(ticket);
        //then
        assertSame(car,fetchCar);
    }
    @Test
    public void should_return_car_when_specify_parkingboy_to_fetch_car() throws Exception {
        //give
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        Manager manager = new Manager(parkingLotList);
        //when
        manager.manageParkingBoy(parkingBoy,parkingLotList);
        manager.setParkable(parkingBoy);
        manager.setFetchable(parkingBoy);
        Ticket ticket = manager.specifyParkingBoyParkCar(car);
        Car fetchCar = manager.specifyParkingBoyFetchCar(ticket);
        //then
        assertSame(car,fetchCar);
    }
    @Test
    public void should_return_car_when_give_ticket() throws Exception {
        //given
        Car car = new Car();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        Manager manager = new Manager(parkingLotList);
        ParkingLot managedParkingLot = new ParkingLot();
        manager.manageParkingLot(managedParkingLot);
        //when
        Ticket ticket = manager.parkCar(car);
        Car fetchCar = manager.fetchCar(ticket);
        //then
        assertSame(car,fetchCar);
    }
}
