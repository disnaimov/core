package org.example.stage3;

public class Terminal {
    private Cargo cargo;
    private Plane currentPlane;
    private final int capacityPerSecond = 10;

    public Terminal(Cargo cargo) {
        this.cargo = cargo;
        this.currentPlane = null;
    }

    public synchronized void unload(Plane plane) {
        if (currentPlane == null) {
            currentPlane = plane;
            System.out.println(Thread.currentThread().getName() + ": Terminal " + cargo + " began unloading the plane with cargo " + plane.getCargo());
        }
    }

    public synchronized void processUnloading(int seconds) {
        if (currentPlane != null) {
            int unloadQuantity = Math.min(capacityPerSecond * seconds, currentPlane.getCapacity() - currentPlane.getLoaded());
            currentPlane.load(unloadQuantity);
            System.out.println(Thread.currentThread().getName() + ": Unloaded " + unloadQuantity + " tons. Remainder: " + (currentPlane.getCapacity() - currentPlane.getLoaded()) + " тонн.");

            if (currentPlane.isFullCapacity()) {
                System.out.println(Thread.currentThread().getName() + ": The plane with cargo " + currentPlane.getCargo() + " unloaded.");
                currentPlane = null;
            }
        }
    }
}
