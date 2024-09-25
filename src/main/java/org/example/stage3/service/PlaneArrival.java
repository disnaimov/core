package org.example.stage3.service;

import org.example.stage3.model.CargoAirport;
import org.example.stage3.model.Plane;

public class PlaneArrival implements Runnable{
    private CargoAirport airport;
    private Plane plane;

    public PlaneArrival(CargoAirport airport, Plane plane) {
        this.airport = airport;
        this.plane = plane;
    }

    @Override
    public void run() {
        try {
            airport.landPlane(plane);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
