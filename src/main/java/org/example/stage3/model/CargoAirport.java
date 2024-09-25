package org.example.stage3.model;

import org.example.stage3.enums.Cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoAirport {
    private final List<Terminal> terminals;
    private final Object lock = new Object();
    private boolean isTerminalBusy = false;
    private volatile boolean isRunning = true;


    public CargoAirport() {
        terminals = new ArrayList<>();
        terminals.add(new Terminal(Cargo.TECHNIQUE));
        terminals.add(new Terminal(Cargo.FOOD));
        terminals.add(new Terminal(Cargo.MEDICINE));
    }

    public void landPlane(Plane plane) throws InterruptedException {
        // Получаем терминал для разгрузки
        Terminal terminalByCargo = getTerminalByCargo(plane.getCargo());
        if (terminalByCargo != null) {
            terminalByCargo.unload(plane); // Параллельная разгрузка, если терминал свободен
        } else {
            System.out.println("Нет доступного терминала для груза: " + plane.getCargo());
        }
    }


    public Terminal getTerminalByCargo(Cargo cargo) {
        return terminals.stream()   // Получаем нужный нам терминал под переданный тип груза
                .filter(terminal -> terminal.cargo() == cargo)
                .findFirst()
                .orElse(null);
    }

    public void stop() {
        isRunning = false; // Останавливает работу Аэропорта
    }
}
