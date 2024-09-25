package org.example.stage3;

import org.example.stage3.enums.Cargo;
import org.example.stage3.model.CargoAirport;
import org.example.stage3.model.Plane;
import org.example.stage3.service.PlaneArrival;

public class Main {
    public static void main(String[] args) {
        CargoAirport airport = new CargoAirport();

        Thread plane1 = new Thread(new PlaneArrival(airport, new Plane(Cargo.TECHNIQUE, 50, 0)));
        Thread plane2 = new Thread(new PlaneArrival(airport, new Plane(Cargo.TECHNIQUE, 50, 50)));
        Thread plane3 = new Thread(new PlaneArrival(airport, new Plane(Cargo.MEDICINE, 50, 25)));
        Thread plane4 = new Thread(new PlaneArrival(airport, new Plane(Cargo.MEDICINE, 100, 40)));
        Thread plane5 = new Thread(new PlaneArrival(airport, new Plane(Cargo.FOOD, 50, 50)));
        Thread plane6 = new Thread(new PlaneArrival(airport, new Plane(Cargo.FOOD, 50, 50)));

        plane1.start();
        plane2.start();
        plane3.start();
        plane5.start();

        try {
            plane1.join();
            plane2.join();
            plane3.join();
            plane5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        plane4.start();
        plane6.start();

        try {
            plane4.join();
            plane6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
