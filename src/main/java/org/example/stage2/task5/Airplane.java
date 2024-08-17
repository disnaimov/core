package org.example.stage2.task5;

abstract class Airplane {
    protected String registrationNumber;

    public Airplane(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public abstract String getDetails();
}
