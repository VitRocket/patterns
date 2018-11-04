package com.github.vitrocket.patterns.factory.map;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.EnumMap;
import java.util.function.Supplier;

/**
 * Example factory pattern with "Map" and "Supplier".
 */
@Log4j2
public class AppFactoryMap {

	public static void main(String[] args) {

		log.info("Example factory pattern with \"Map\" and \"Supplier\"");

		PrinterFactory.getPrinter(PrinterFactory.PrinterType.FIRST).print();
		PrinterFactory.getPrinter(PrinterFactory.PrinterType.SECOND).print();
	}

}

class PrinterFactory {

	public enum PrinterType {
		FIRST,
		SECOND
	}

	private static EnumMap<PrinterType, Supplier<Printer>> makers;

	static {
		makers = new EnumMap<>(PrinterType.class);
		makers.put(PrinterType.FIRST, PrinterFirst::new);
		makers.put(PrinterType.SECOND, PrinterSecond::new);
	}

	static Printer getPrinter(PrinterType type) {
		Supplier<Printer> supplier = makers.get(type);
		if (supplier != null) {
			return supplier.get();
		}
		throw new IllegalArgumentException("Can't get printer: " + type);
	}
}

interface Printer {
	void print();
}

@Log4j2
@ToString
class PrinterFirst implements Printer {

	@Override
	public void print() {
		log.info(toString());
	}
}

@Log4j2
@ToString
class PrinterSecond implements Printer {

	@Override
	public void print() {
		log.info(toString());
	}
}
