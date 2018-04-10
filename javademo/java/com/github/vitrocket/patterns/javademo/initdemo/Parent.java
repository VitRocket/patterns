package com.github.vitrocket.patterns.javademo.initdemo;

public class Parent {

    public final static String PUBLIC_STATIC_STRING = initPublicStaticField();
    private final static String privateStaticString = initPrivateStaticField();
    public final String publicFinalString = initPublicField();
    private final String privateFinalString = initPrivateField();

    static {
        System.out.println("1.3 - Init static block");
    }

    {
        System.out.println("2.6 - Non-static block");
    }

    public Parent() {
        System.out.println("2.7 - Constructor");
    }

    private static String initPublicStaticField() {
        System.out.println("1.1 - Init public static field");
        return "Public static field";
    }

    private static String initPrivateStaticField() {
        System.out.println("1.2 - Init private static field");
        return "Private static field";
    }

    public static String getPrivateStaticString() {
        System.out.println("Get private static field");
        return privateStaticString;
    }

    private String initPublicField() {
        System.out.println("2.4 - Init public field");
        return "Private field";
    }

    private String initPrivateField() {
        System.out.println("2.5 - Init private field");
        return "Private field";
    }


}
