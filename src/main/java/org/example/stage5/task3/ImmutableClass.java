package org.example.stage5.task3;

import java.util.Collections;
import java.util.List;
/*
Создать иммутабельный класс, у которого есть аттрибут список, который тоже должен быть иммутабельным
 */
public class ImmutableClass {
    private final List<String> items;

    public ImmutableClass(List<String> items) {
        this.items = Collections.unmodifiableList(List.copyOf(items));
    }

    public List<String> getItems() {
        return items;
    }
}
