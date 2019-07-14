package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.List;

public class Manager {
    private HashMap<ParkingBoy, List<ParkingLot>> managementList;
    private List<ParkingLot> prividedParkingLots;
    private Parkable parkable;
    private Fetchable fetchable;

    public Manager(List<ParkingLot> prividedParkingLots) {
        this.prividedParkingLots = prividedParkingLots;
        managementList = new HashMap<>();
    }

    public void setParkable(Parkable parkable) {
        this.parkable = parkable;
    }

    public void setFetchable(Fetchable fetchable) {
        this.fetchable = fetchable;
    }

    public void manageParkingBoy(ParkingBoy parkingBoy, List<ParkingLot> parkingLots){
        parkingBoy.setParkingLots(parkingLots);
        this.managementList.put(parkingBoy,parkingLots);
    }

    public Ticket specifyParkingBoyParkCar(Car car) throws Exception {
        return this.parkable.parkCar(car);
    }

    public Car specifyParkingBoyFetchCar(Ticket ticket) throws Exception {
        return this.fetchable.fetchCar(ticket);
    }
}
