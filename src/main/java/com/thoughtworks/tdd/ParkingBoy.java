package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parkCar(Car car) throws Exception {
        return parkingLot.parkCar(car);
    }

    public Car fetchCar(Ticket ticket) throws Exception {
        return parkingLot.getCar(ticket);
    }

    public String responseMessge(Ticket ticket) {
        try {
            parkingLot.getCar(ticket);
        } catch (Exception e) {
            return "Unrecognized parking ticket.";
        }
        return "";
    }

    public Car fetchCar() throws Exception {
        return parkingLot.getCar();
    }
}
