package org.example.stage3.model;

import org.example.stage3.enums.Cargo;

public record Terminal(Cargo cargo) {

    public synchronized void unload(Plane plane) {

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

        // После того как разгрузка завершена
        System.out.println("Самолет " + plane + " с грузом " + plane.getCargo() + " разгружен");
    }
}
