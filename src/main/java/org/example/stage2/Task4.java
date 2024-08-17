package org.example.stage2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
/*
Расширить фильтр из задачи 3 параметром сортировки.
То есть, в фильтре можно указать поле, по которому будет отсортирована итоговая коллекция - по имени или возрасту.
 */
public class Task4 {

    public List<Person> personFilter(List<Person> persons, String filterName, LocalDate filterDate, String filterGender, SortedCriteria sortedCriteria) {
        return persons.stream()
                .filter(person -> filterName == null || person.name().toLowerCase().contains(filterName.toLowerCase()))
                .filter(person -> filterDate == null || person.dateOfBorn().isBefore(filterDate))
                .filter(person -> filterGender == null || person.gender().equalsIgnoreCase(filterGender))
                .sorted((p1, p2) -> {
                    switch (sortedCriteria) {
                        case NAME:
                            return p1.name().compareToIgnoreCase(p2.name());
                        case AGE:
                            return p1.dateOfBorn().compareTo(p2.dateOfBorn());
                        default:
                            return 0;
                    }
                })
                .collect(Collectors.toList());
    }
}
