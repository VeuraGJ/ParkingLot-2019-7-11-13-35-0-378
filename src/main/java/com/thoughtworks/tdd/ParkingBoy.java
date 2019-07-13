package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parkCar(Car car) {
        return parkingLot.parkCar(car);
    }

    public Car fetchCar(Ticket ticket) {
        return parkingLot.getCar(ticket);
    }
}
