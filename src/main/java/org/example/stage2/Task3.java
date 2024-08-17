package org.example.stage2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
/*
Есть коллекция людей из задачи 1.
Необходимо реализовать метод, который будет производить поиск людей по этой коллекции по любым полям.
В фильтре можно указать имя, возраст и пол. Например, нужно найти всех людей, у кого имя включает Иван и возраст больше 25 лет.
Метод необходимо покрыть unit-тестами.
 */
public class Task3 {

    public List<Person> personFilter(List<Person> persons, String filterName, LocalDate filterDate, String filterGender) {
        return persons.stream()
                .filter(person -> filterName == null || person.name().toLowerCase().contains(filterName.toLowerCase()))
                .filter(person -> filterDate == null || person.dateOfBorn().isBefore(filterDate))
                .filter(person -> filterGender == null || person.gender().equalsIgnoreCase(filterGender))
                .collect(Collectors.toList());
    }
}
