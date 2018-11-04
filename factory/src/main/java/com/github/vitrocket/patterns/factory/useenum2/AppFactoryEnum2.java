package com.github.vitrocket.patterns.factory.useenum2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Example factory pattern with custom FunctionalInterface and Enum version 2.
 */
@Log4j2
public class AppFactoryEnum2 {

	public static void main(String[] args) {

		log.info("Example factory pattern with custom FunctionalInterface and \"Enum\" version 2.");

		PrinterFactory.createPrinter(PrinterFactory.PrinterType.HP, 20).print();
		PrinterFactory.createPrinter(PrinterFactory.PrinterType.CANON, 15).print();

	}

}

class PrinterFactory {

	@RequiredArgsConstructor
	@Getter(AccessLevel.PRIVATE)
	public enum PrinterType {

		HP(PrinterFirst::new),
		CANON(PrinterSecond::new);

		private final PrinterConstructor constructor;
	}

	@FunctionalInterface
	private interface PrinterConstructor {
		Printer create(int speed);
	}

	static Printer createPrinter(PrinterType type, int speed) {
		return type.getConstructor().create(speed);
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

@Log4j2
@ToString(callSuper = true)
class PrinterFirst extends PrinterAbstract {

	PrinterFirst(int speed) {
		super("HP", speed);
	}

	@Override
	public void print() {
		log.info(toString());
	}
}

@Log4j2
@ToString(callSuper = true)
class PrinterSecond extends PrinterAbstract {

	PrinterSecond(int speed) {
		super("Canon", speed);
	}

	@Override
	public void print() {
		log.info(toString());
	}
}