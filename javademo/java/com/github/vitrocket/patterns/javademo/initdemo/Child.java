package com.github.vitrocket.patterns.javademo.initdemo;

public class Child extends Parent {

    public final static String PUBLIC_STATIC_STRING_CHILD = initPublicStaticFieldCild();
    private final static String privateStaticStringChild = initPrivateStaticFieldChild();
    public final String publicFinalStringChild = initPublicFieldChild();
    private final String privateFinalString = initPrivateFieldChild();

    static {
        System.out.println("    1.3 - Init static block Child");
    }

    {
        System.out.println("    2.6 - Non-static block Child");
    }

    public Child() {
        System.out.println("    2.7 - Constructor Child");
    }

    private static String initPublicStaticFieldCild() {
        System.out.println("    1.1 - Init public static field Child");
        return "    Public static field";
    }

    private static String initPrivateStaticFieldChild() {
        System.out.println("    1.2 - Init private static field Child");
        return "    Private static field";
    }

    public static String getPrivateStaticString() {
        System.out.println("    Get private static field Child");
        return privateStaticStringChild;
    }

    private String initPublicFieldChild() {
        System.out.println("    2.4 - Init public field Child");
        return "    Private field Child";
    }

    private String initPrivateFieldChild() {
        System.out.println("    2.5 - Init private field Child");
        return "    Private field Child";
    }

}
