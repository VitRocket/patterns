package com.github.vitrocket.patterns.factory.useenum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

public class AppEnum {

    public static void main(String[] args) {

        System.out.println("Hello!");

        PrinterFactory.createPrinter(PrinterFactory.PrinterType.FIRST).print();
        PrinterFactory.createPrinter(PrinterFactory.PrinterType.SECOND).print();

    }

}

class PrinterFactory {

    @RequiredArgsConstructor
    @Getter(AccessLevel.PRIVATE)
    public static enum PrinterType {
        FIRST(PrinterFirst::new),
        SECOND(PrinterSecond::new);

        private final Supplier<Printer> constructor;

    }

    static Printer createPrinter(PrinterType type) {
        return type.getConstructor().get();
    }

}

interface Printer {
    void print();
}

class PrinterFirst implements Printer {
    @Override
    public void print() {
        System.out.println("First printer: Printing now!");
    }
}

class PrinterSecond implements Printer {
    @Override
    public void print() {
        System.out.println("Second printer: Printing now!");
    }
}



