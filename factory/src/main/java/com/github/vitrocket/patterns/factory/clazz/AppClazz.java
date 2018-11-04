package com.github.vitrocket.patterns.factory.clazz;

import lombok.extern.log4j.Log4j2;

/**
 * Example factory pattern with "Class".
 */
@Log4j2
public class AppClazz {

	public static void main(String[] args) {

		log.info("Example factory pattern with \"Class\".");

		String printerName1 = "A";
		String printerName2 = "B";

		try {

			Class<?> aClass = Class.forName("com.github.vitrocket.patterns.factory.clazz.Printer" + printerName1);
			Printer printer = (Printer) aClass.newInstance();
			printer.print();

			Class<?> bClass = Class.forName("com.github.vitrocket.patterns.factory.clazz.Printer" + printerName2);
			printer = (Printer) bClass.newInstance();
			printer.print();

		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			log.error(e.getMessage());
		}

	}
}

interface Printer {
	void print();
}

@Log4j2
class PrinterA implements Printer {
	@Override
	public void print() {
		log.info(this.getClass().getName() + " is printing now!");
	}
}

@Log4j2
class PrinterB implements Printer {
	@Override
	public void print() {
		log.info(this.getClass().getName() + " is printing now!");
	}
}

