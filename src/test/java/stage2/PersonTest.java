package stage2;

import org.example.stage2.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {

    @Test
    public void testEquals_SameObject() {
        Person person = new Person("Alice", LocalDate.of(1990, 1, 1), "Female");
        assertEquals(person, person, "A person should be equal to itself");
    }

    @Test
    public void testEquals_SameValues() {
        Person person1 = new Person("Alice", LocalDate.of(1990, 1, 1), "Female");
        Person person2 = new Person("Alice", LocalDate.of(1990, 1, 1), "Female");
        assertEquals(person1, person2, "Two persons with the same values should be equal");
    }

    @Test
    public void testEquals_DifferentName() {
        Person person1 = new Person("Alice", LocalDate.of(1990, 1, 1), "Female");
        Person person2 = new Person("Bob", LocalDate.of(1990, 1, 1), "Female");
        assertNotEquals(person1, person2, "Persons with different names should not be equal");
    }

    @Test
    public void testEquals_DifferentBirthDate() {
        Person person1 = new Person("Alice", LocalDate.of(1990, 1, 1), "Female");
        Person person2 = new Person("Alice", LocalDate.of(1991, 1, 1), "Female");
        assertNotEquals(person1, person2, "Persons with different birth dates should not be equal");
    }

    @Test
    public void testEquals_DifferentGender() {
        Person person1 = new Person("Alice", LocalDate.of(1990, 1, 1), "Female");
        Person person2 = new Person("Alice", LocalDate.of(1990, 1, 1), "Male");
        assertNotEquals(person1, person2, "Persons with different genders should not be equal");
    }

    @Test
    public void testEquals_Null() {
        Person person = new Person("Alice", LocalDate.of(1990, 1, 1), "Female");
        assertNotEquals(null, person, "A person should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        Person person = new Person("Alice", LocalDate.of(1990, 1, 1), "Female");
        String nonPersonObject = "I am not a Person";
        assertNotEquals(person, nonPersonObject, "A person should not be equal to object of a different class");
    }
}
