package org.example.stage3;

import java.util.HashMap;
import java.util.Map;

public class CargoAirport {
    private Map<String, Terminal> terminals;
    private final Object lock = new Object();
    private boolean isTerminalBusy = false;
    private volatile boolean isRunning = true;


    public CargoAirport() {
        terminals = new HashMap<>();
        terminals.put("tech", new Terminal(Cargo.TECHNIQUE));
        terminals.put("food", new Terminal(Cargo.FOOD));
        terminals.put("med", new Terminal(Cargo.MEDICINE));
    }

    public void landPlane(Plane plane) throws InterruptedException {
        synchronized (lock) {
            while (!isRunning) {
                return;
            }
            while (isTerminalBusy) {
                lock.wait();
            }
            isTerminalBusy = true;
            System.out.println("Plane landed: " + plane.getCargo());
            Terminal terminal = terminals.get(plane.getCargo());
            terminal.unload(plane);
            isTerminalBusy = false;
            lock.notify();
        }
    }

    public void processTime(int seconds) {
        for (Terminal terminal : terminals.values()) {
            terminal.processUnloading(seconds);
        }
    }

    public void stop() {
        isRunning = false;
    }
}
