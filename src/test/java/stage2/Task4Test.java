package stage2;

import org.example.stage2.Person;
import org.example.stage2.SortedCriteria;
import org.example.stage2.Task4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    Task4 task4;

    @BeforeEach
    void setUp() {
        task4 = new Task4();
    }

    @Test
    void testFilterAndSortByName() {
        List<Person> persons = List.of(
                new Person("Ivan", LocalDate.of(1990, 1, 1), "Male"),
                new Person("Anna", LocalDate.of(2000, 1, 1), "Female"),
                new Person("Sergey", LocalDate.of(1985, 1, 1), "Male")
        );

        List<Person> result = task4.personFilter(persons, null, null, null, SortedCriteria.NAME);
        assertEquals("Anna", result.get(0).name());
        assertEquals("Ivan", result.get(1).name());
        assertEquals("Sergey", result.get(2).name());
    }

    @Test
    void testFilterAndSortByAge() {
        List<Person> persons = List.of(
                new Person("Ivan", LocalDate.of(1990, 1, 1), "Male"),
                new Person("Anna", LocalDate.of(2000, 1, 1), "Female"),
                new Person("Sergey", LocalDate.of(1985, 1, 1), "Male")
        );

        List<Person> result = task4.personFilter(persons, null, null, null, SortedCriteria.AGE);
        assertEquals("Sergey", result.get(0).name());
        assertEquals("Ivan", result.get(1).name());
        assertEquals("Anna", result.get(2).name());
    }
}
