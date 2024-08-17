package org.example.stage2.task5;

import java.util.ArrayList;
import java.util.List;
/*
Необходимо реализовать программу для отображения данных о парке авиакомпании.
В авиакомпании могут быть самолеты и вертолеты, которые, в свою очередь, могут быть пассажирскими и грузовыми.
У пассажирских воздушных судов есть количество посадочных мест, а грузовых - грузоподъемность.
У самолетов также есть минимальная длинна полосы для взлета и посадки, а у вертолетов - размер винта.
У каждого воздушного судна есть регистрационный номер.
Необходимо реализовать метод, который выведет список всех воздушных судов авиакомпании, с указанием всех их параметров.
Список воздушных судов можно захардкодить.
Например:
73089 - Пассажирский самолет - 215 пассажиров - полоса 2100 метров
76501 - Грузовой самолет - 60 тонн - полоса 2300 метров
68345 - Пассажирский вертолет - размер винта 16,4 метров
 */
public class Airline {

    private final List<Airplane> fleet;

    public Airline() {
        fleet = new ArrayList<>();
        fleet.add(new PassengerPlane("73089", 215, 2100));
        fleet.add(new CargoPlane("76501", 60, 2300));
        fleet.add(new PassengerHelicopter("68345", 16));
    }

    public void displayFleet() {
        for (Airplane plane : fleet) {
            System.out.println(plane.getDetails());
        }
    }

    public static void main(String[] args) {
        Airline airline = new Airline();
        airline.displayFleet();
    }
}
