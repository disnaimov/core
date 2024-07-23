package org.example;

import java.util.ArrayList;
import java.util.List;

/*
Написать код, в ходе выполнения которого будет генерироваться OutOfMemoryError.
Сделать 3 разных варианта получения этой ошибки.
Код запускать с указанием параметров памяти JVM (xms, xmx и так далее)
 */
public class Task4 {

    static void method() {
        method();
    }

    static class OutOfMemory1 {
        public static void main(String[] args) {
            List<Object> list = new ArrayList<>();

            try {
                while (true) {
                    list.add(new Object());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("Out of memory " + e);
            }
        }
    }

    static class OutOfMemory2 {
        public static void main(String[] args) {
            try {
                    method();
            } catch (OutOfMemoryError e) {
                System.out.println("Out of memory " + e);
            }
        }
    }

    static class OutOfMemory3 {
        public static void main(String[] args) {
            try {
                int[] array = new int[Integer.MAX_VALUE];
            } catch (OutOfMemoryError e) {
                System.out.println("Out of memory " + e);
            }
        }
    }
}
