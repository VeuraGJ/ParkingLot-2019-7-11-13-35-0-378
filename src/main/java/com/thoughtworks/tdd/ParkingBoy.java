package com.thoughtworks.tdd;

public class ParkingBoy implements Parkable, Fetchable {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    @Override
    public Ticket parkCar(Car car) throws Exception {
        return parkingLot.parkCar(car);
    }
    @Override
    public Car fetchCar(Ticket ticket) throws Exception {
        return parkingLot.fetchCar(ticket);
    }


    @Override
    public Car fetchCar() throws Exception {
        return parkingLot.fetchCar();
    }
}
