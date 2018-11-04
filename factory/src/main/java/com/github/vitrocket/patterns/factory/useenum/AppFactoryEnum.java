package com.github.vitrocket.patterns.factory.useenum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.function.Supplier;

/**
 * Example factory pattern with Supplier and Enum.
 */
@Log4j2
public class AppFactoryEnum {

	public static void main(String[] args) {
		log.info("Example factory pattern with \"Supplier\" and \"Enum\".");

		PrinterFactory.createPrinter(PrinterFactory.PrinterType.BLACK_AND_WHITE).print();
		PrinterFactory.createPrinter(PrinterFactory.PrinterType.COLOR).print();

	}

}

class PrinterFactory {

	@RequiredArgsConstructor
	@Getter(AccessLevel.PRIVATE)
	public enum PrinterType {
		BLACK_AND_WHITE(PrinterBlackAndWhite::new),
		COLOR(PrinterColor::new);

		private final Supplier<Printer> constructor;

	}

	static Printer createPrinter(PrinterType type) {
		return type.getConstructor().get();
	}

}

interface Printer {
	void print();
}

@Log4j2
class PrinterBlackAndWhite implements Printer {
	@Override
	public void print() {
		log.info("Black and White printer: Printing now!");
	}
}

@Log4j2
class PrinterColor implements Printer {
	@Override
	public void print() {
		log.info("Color printer: Printing now!");
	}
}



