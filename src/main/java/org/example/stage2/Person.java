package org.example.stage2;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private String name;
    private LocalDate dateOfBorn;
    private String gender;

    public Person(String name, LocalDate dateOfBorn, String gender) {
        this.name = name;
        this.dateOfBorn = dateOfBorn;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBorn() {
        return dateOfBorn;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(dateOfBorn, person.dateOfBorn) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBorn, gender);
    }
}
