package com.github.vitrocket.patterns.singleton.base;

public class BaseSingleton {

    private static BaseSingleton instance;

    private String value;

    public String getValue() {
        return value;
    }

    private BaseSingleton(String value) {
        this.value = value;
    }

    public static BaseSingleton getInstance(String value) {
        if (instance == null) {
            instance = new BaseSingleton(value);
        }
        return instance;
    }
}
