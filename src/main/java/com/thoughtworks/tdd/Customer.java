package com.thoughtworks.tdd;

public class Customer  {
    private Parkable parkable;
    private Fetchable fetchCar;
    private Car myCar;
    private Ticket parkingTicket;

    public void setParkable(Parkable parkable) {
        this.parkable = parkable;
    }

    public void setFetchCar(Fetchable fetchCar) {
        this.fetchCar = fetchCar;
    }

    public Car getMyCar() {
        return myCar;
    }

    public void setMyCar(Car myCar) {
        this.myCar = myCar;
    }

    public Ticket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(Ticket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public String fetchMyCar(){
        try {
            fetchCar.fetchCar(parkingTicket);
        } catch (Exception e) {
            return e.getMessage();
        }
        return null;
    }
}
