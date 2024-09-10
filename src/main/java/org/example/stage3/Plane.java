package org.example.stage3;

public class Plane {
    private Cargo cargo;
    private int capacity;
    private int loaded;

    public Plane(Cargo cargo, int capacity, int loaded) {
        if (!(capacity == 20 || capacity == 50 || capacity == 100)) {
            throw new IllegalArgumentException("Unacceptable load capacity: " + capacity);
        }

        if (loaded > capacity) {
            throw new IllegalArgumentException("Initial load exceeds capacity: " + loaded);
        }
        this.cargo = cargo;
        this.capacity = capacity;
        this.loaded = loaded;
    }

    public String getCargo() {
        return cargo.getKey();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLoaded() {
        return loaded;
    }

    public void load(int quantity) {
        if (loaded + quantity > capacity) {
            System.out.println("Error: attempt to load " + quantity + " tons exceeds capacity " + capacity + " tons.");
        } else {
            loaded += quantity;
            System.out.println("The plane was successfully loaded: " + quantity + " tons. Current capacity: " + loaded + " tons.");
        }

    }

    public boolean isFullCapacity() {
        return loaded >= capacity;
    }
}
