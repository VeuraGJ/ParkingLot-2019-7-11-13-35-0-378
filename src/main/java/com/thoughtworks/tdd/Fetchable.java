package com.thoughtworks.tdd;

public interface Fetchable {
    public Car fetchCar(Ticket ticket) throws Exception;
    public Car fetchCar() throws Exception;
}
