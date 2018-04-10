package com.github.vitrocket.patterns.javademo.initdemo;

public class App {

    public static void main(String[] args) {
        System.out.println("----->> Start program <<-----");
        System.out.println("Hello!");

//        System.out.println("----->> Get static value <<-----");
////        String init = Parent.PUBLIC_STATIC_STRING;
//        String init = Parent.getPrivateStaticString();
//        System.out.println(init);

        System.out.println("----->> Create object <<-----");
        Parent parent = new Parent();
    }
}


//        ----->> Create object <<-----
//        1.1 - Init public static field
//        1.2 - Init private static field
//        1.3 - Init static block
//        2.4 - Init public field
//        2.5 - Init private field
//        2.6 - Non-static block
//        2.7 - Constructor

