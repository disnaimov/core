package org.example.stage2.task5;

public class PassengerHelicopter extends Airplane{

    private final int screwSize;

    public PassengerHelicopter(String registrationNumber, int screwSize) {
        super(registrationNumber);
        this.screwSize = screwSize;
    }

    @Override
    public String getDetails() {
        return String.format("%s - Пассажирский вертолет - размер винта %d метров",
                registrationNumber, screwSize);
    }
}
