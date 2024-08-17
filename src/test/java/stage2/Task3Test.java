package stage2;

import org.example.stage2.Person;
import org.example.stage2.Task3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {

    Task3 task3;

    @BeforeEach
    void setUp() {
        task3 = new Task3();
    }

    @Test
    void testFilterByName() {
        List<Person> persons = List.of(
                new Person("Ivan", LocalDate.of(1990, 1, 1), "Male"),
                new Person("Anna", LocalDate.of(2000, 1, 1), "Female")
        );

        List<Person> result = task3.personFilter(persons, "Ivan", null, null);
        assertEquals(1, result.size());
        assertEquals("Ivan", result.get(0).name());
    }

    @Test
    void testFilterByAge() {
        List<Person> persons = List.of(
                new Person("Ivan", LocalDate.of(1990, 1, 1), "Male"),
                new Person("Anna", LocalDate.of(2000, 1, 1), "Female")
        );

        List<Person> result = task3.personFilter(persons, null, LocalDate.of(1998, 1, 1), null);
        assertEquals(1, result.size());
        assertEquals("Ivan", result.get(0).name());
    }

    @Test
    void testFilterByGender() {
        List<Person> persons = List.of(
                new Person("Ivan", LocalDate.of(1990, 1, 1), "Male"),
                new Person("Anna", LocalDate.of(2000, 1, 1), "Female")
        );

        List<Person> result = task3.personFilter(persons, null, null, "Female");
        assertEquals(1, result.size());
        assertEquals("Anna", result.get(0).name());
    }

    @Test
    void testCombinedFilters() {
        List<Person> persons = List.of(
                new Person("Ivan", LocalDate.of(1990, 1, 1), "Male"),
                new Person("Petrov", LocalDate.of(1985, 1, 1), "Male"),
                new Person("Anna", LocalDate.of(2000, 1, 1), "Female")
        );

        List<Person> result = task3.personFilter(persons, "Ivan", LocalDate.of(1998, 1, 1), "Male");
        assertEquals(1, result.size());
        assertEquals("Ivan", result.get(0).name());
    }

    @Test
    void testNoMatches() {
        List<Person> persons = List.of(
                new Person("Ivan", LocalDate.of(1990, 1, 1), "Male")
        );

        List<Person> result = task3.personFilter(persons, "Petrov", null, null);
        assertTrue(result.isEmpty());
    }

    @Test
    void testEmptyList() {
        List<Person> result = task3.personFilter(List.of(), null, null, null);
        assertTrue(result.isEmpty());
    }
}
