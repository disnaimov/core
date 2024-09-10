package org.example.stage3;

public enum Cargo {
    TECHNIQUE("tech"),
    FOOD("food"),
    MEDICINE("med");

    private final String key;

    Cargo(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
