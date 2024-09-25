package org.example.stage3.model;

import org.example.stage3.enums.Cargo;

public class Terminal {
    private final Cargo cargo;
    private boolean isBusy = false;

    public Terminal(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo cargo() {
        return cargo;
    }

    public synchronized void unload(Plane plane) throws InterruptedException {
        while (isBusy) {
            wait(); // Ждем, пока терминал не освободиться
        }

        System.out.println("Самолет " + plane + " с грузом " + plane.getCargo() + " имеет начальную загруженность: " + plane.getLoaded());

        while (plane.getLoaded() > 0) {
            int capacityPerSecond = 10;

            // Рассчитываем новую загрузку
            int newLoad = plane.getLoaded() - capacityPerSecond;

            // Если новая загрузка меньше 0, устанавливаем в 0
            if (newLoad < 0) {
                newLoad = 0;
            }

            plane.setLoaded(newLoad);
            System.out.println("Самолет " + plane + " с грузом " + plane.getCargo() + " Разгружается, текущая загруженность " + plane.getLoaded());
        }


        Thread.sleep(2000);
        isBusy = false;
        notifyAll(); // Освободили терминал и уведомили об этом

        // После того как разгрузка завершена
        System.out.println("Самолет " + plane + " с грузом " + plane.getCargo() + " разгружен");
    }
}
