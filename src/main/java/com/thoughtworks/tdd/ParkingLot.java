package com.thoughtworks.tdd;



import java.util.HashMap;

public class ParkingLot implements Parkable, Fetchable {
    private HashMap<Ticket,Car> parkingTicketCar;
    private final int CAPACITY = 10;

    public ParkingLot() {
        parkingTicketCar = new HashMap<>();
    }

    @Override
    public Ticket parkCar(Car car) throws Exception {
        if(parkingTicketCar.size() == CAPACITY){
            throw new Exception("Not enough position.");
        }
        Ticket ticket = new Ticket();
        parkingTicketCar.put(ticket,car);
        return ticket;
    }
    @Override
    public Car fetchCar(Ticket ticket) throws Exception{
        if(ticket == null){
            throw new Exception("Please provide your parking ticket.");
        }
        Car car = parkingTicketCar.remove(ticket);
        if(car == null) {
            throw new Exception("Unrecognized parking ticket.");
        }
        return car;
    }


    public int getEmptyPosition() {
        return CAPACITY-parkingTicketCar.size();
    }
}
