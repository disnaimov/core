package org.example.stage2.task5;

public class CargoPlane extends Airplane{
    private final int payloadCapacity;
    private final int runwayLength;

    public CargoPlane(String registrationNumber, int payloadCapacity, int runwayLength) {
        super(registrationNumber);
        this.payloadCapacity = payloadCapacity;
        this.runwayLength = runwayLength;
    }

    @Override
    public String getDetails() {
        return String.format("%s - Грузовой самолет - %d тонн - полоса %d метров",
                registrationNumber, payloadCapacity, runwayLength);
    }
}
