package org.example.stage5.task3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass(List.of("Item1", "Item2", "Item3"));

        System.out.println(immutableClass.getItems());

        immutableClass.getItems().add("Item4");
    }
}
