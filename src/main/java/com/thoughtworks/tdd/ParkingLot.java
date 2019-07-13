package com.thoughtworks.tdd;



import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket,Car> parkingTicketCar;

    public ParkingLot() {
        parkingTicketCar = new HashMap<>();
    }

    public Ticket parkCar(Car car) {
        Ticket ticket = new Ticket();
        parkingTicketCar.put(ticket,car);
        return ticket;
    }

    public Car getCar(Ticket ticket) {
        return parkingTicketCar.get(ticket);
    }
}
