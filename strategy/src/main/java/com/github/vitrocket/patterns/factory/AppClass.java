package com.github.vitrocket.patterns.factory;

/**
 * Created by VitRocket on 21.05.2018.
 */
public class AppClass {

    public static void main(String[] args) {
        String printerName = "First";
        try {
            Class<?> aClass = Class.forName("com.github.vitrocket.patterns.factory.Printer" + printerName);
            Printer printer = (Printer) aClass.newInstance();
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
        System.out.println("Printing now!");
    }
}
