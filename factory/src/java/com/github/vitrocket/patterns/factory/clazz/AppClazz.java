package com.github.vitrocket.patterns.factory.clazz;

/**
 * Created by VitRocket on 21.05.2018.
 */
public class AppClazz {

    public static void main(String[] args) {
        String printerName1 = "First";
        String printerName2 = "Second";
        try {
            Class<?> aClass = Class.forName("com.github.vitrocket.patterns.factory.clazz.Printer" + printerName1);
            Printer printer = (Printer) aClass.newInstance();
            printer.print();

            aClass = Class.forName("com.github.vitrocket.patterns.factory.clazz.Printer" + printerName2);
            printer = (Printer) aClass.newInstance();
            printer.print();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

interface Printer {
    void print();
}

class PrinterFirst implements Printer {
    @Override
    public void print() {
        System.out.println("First Printing now!");
    }
}

class PrinterSecond implements Printer {
    @Override
    public void print() {
        System.out.println("Second Printing now!");
    }
}

