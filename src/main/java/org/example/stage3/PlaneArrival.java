package org.example.stage3;

public class PlaneArrival implements Runnable{
    private CargoAirport airport;
    private Plane plane;

    public PlaneArrival(CargoAirport cargoAirport, Plane plane) {
        this.airport = cargoAirport;
        this.plane = plane;
    }

    @Override
    public void run() {
        try {
            airport.landPlane(plane);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                airport.processTime(1);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
