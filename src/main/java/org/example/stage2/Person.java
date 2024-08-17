package org.example.stage2;

import java.time.LocalDate;

/*
Реализовать класс, описывающий человека (имя, дата рождения, пол), переопределить методы equals и hashCode
и написать unit-тесты для метода equals.
 */
public record Person(String name, LocalDate dateOfBorn, String gender) {

}
