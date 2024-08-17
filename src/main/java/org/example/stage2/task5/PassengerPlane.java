package org.example.stage2.task5;

public class PassengerPlane extends Airplane {

    private final int passengerCapacity;
    private final int runwayLength;

    public PassengerPlane(String registrationNumber, int passengerCapacity, int runwayLength) {
        super(registrationNumber);
        this.passengerCapacity = passengerCapacity;
        this.runwayLength = runwayLength;
    }

    @Override
    public String getDetails() {
        return String.format("%s - Пассажирский самолет - %d пассажиров - полоса %d метров",
                registrationNumber, passengerCapacity, runwayLength);
    }
}
