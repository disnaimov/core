package org.example.stage3.model;

import org.example.stage3.enums.Cargo;

public class Plane {
    private final Cargo cargo;
    private int loaded;

    public Plane(Cargo cargo, int capacity, int loaded) {
        if (!(capacity == 20 || capacity == 50 || capacity == 100)) {
            throw new IllegalArgumentException("Недопустимое значение грузоподъемности: " + capacity);
        }

        if (loaded > capacity) {
            throw new IllegalArgumentException("Начальная загрузка превышает грузоподъемность: " + loaded);
        }
        this.cargo = cargo;
        this.loaded = loaded;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public int getLoaded() {
        return loaded;
    }

    public void setLoaded(int loaded) {
        this.loaded = loaded;
    }
}
