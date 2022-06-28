package com.github.vitrocket.patterns.singleton.base;

public class AppBaseSingleton {

    public static void main(String[] args) {
        BaseSingleton first = BaseSingleton.getInstance("First");
        BaseSingleton second = BaseSingleton.getInstance("Second");

        System.out.println(first == second);

        System.out.println(first.getValue());

        System.out.println(second.getValue());
    }

}
