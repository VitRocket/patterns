package com.github.vitrocket.patterns.factory.useenum2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class AppEnum {

    public static void main(String[] args) {

        System.out.println("Hello!");

        PrinterFactory.createPrinter(PrinterFactory.PrinterType.FIRST, "HP", 20).print();
        PrinterFactory.createPrinter(PrinterFactory.PrinterType.SECOND, "Canon", 15).print();

    }

}

class PrinterFactory {

    @RequiredArgsConstructor
    @Getter(AccessLevel.PRIVATE)
    public static enum PrinterType {

//        FIRST((c, t) -> new PrinterFirst(c, t)),
//        SECOND((c, t) -> new PrinterSecond(c, t));

        FIRST(PrinterFirst::new),
        SECOND(PrinterSecond::new);

        private final PrinterConstructor constructor;
    }

    @FunctionalInterface
    private interface PrinterConstructor {
        Printer create(String name, int speed);
    }

    public static Printer createPrinter(PrinterType type, String name, int speed) {
        return type.getConstructor().create(name, speed);
    }

}

interface Printer {
    void print();
}

@RequiredArgsConstructor
@ToString
abstract class PrinterAbstract implements Printer {
    private final String name;
    private final int speed;
}

@ToString(callSuper = true)
class PrinterFirst extends PrinterAbstract {

    PrinterFirst(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void print() {
        System.out.println(toString());
    }
}

@ToString(callSuper = true)
class PrinterSecond extends PrinterAbstract {

    PrinterSecond(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void print() {
        System.out.println(toString());
    }
}