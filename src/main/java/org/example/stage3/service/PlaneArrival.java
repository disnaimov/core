package org.example.stage3.service;

import org.example.stage3.model.CargoAirport;
import org.example.stage3.model.Plane;

public class PlaneArrival implements Runnable{
    private CargoAirport airport;
    private Plane plane;

    @Override
    public void run() {
        try {
            airport.landPlane(plane);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
