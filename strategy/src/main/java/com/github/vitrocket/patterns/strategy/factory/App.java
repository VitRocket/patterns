package com.github.vitrocket.patterns.strategy.factory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


@Log4j2
public class App {

    public static void main(String[] args) {
        log.info("Hello!");

        StrategyPrintFactory factory = new StrategyPrintFactory();
        StrategyPrinting printer = factory.getPrinter(new Photo());
        printer.doPrint();

        printer = factory.getPrinter(new Document());
        printer.doPrint();

        try {
            printer = factory.getPrinter(new NewsPaper());
            printer.doPrint();
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }
    }
}

class StrategyPrintFactory {

    private static Map<String, Supplier<StrategyPrinting>> map = new HashMap<>();

    static {
        map.put("PHOTO", PrinterPhoto::new);
        map.put("DOCUMENT", PrinterDocument::new);
    }

    StrategyPrinting getPrinter(Model model) {
        Supplier<StrategyPrinting> supplier = map.get(model.getType().name().toUpperCase());
        if (supplier != null) {
            StrategyPrinting printer = supplier.get();
            printer.setModel(model);
            return printer;
        }
        throw new IllegalArgumentException("Can't printing model: " + model.getType().name());
    }
}

enum ModelType {
    Photo,
    Document,
    NewsPaper
}

@RequiredArgsConstructor
class Model {
    @Getter
    private final ModelType type;
}

class Photo extends Model {
    Photo() {
        super(ModelType.Photo);
    }
}

class Document extends Model {
    Document() {
        super(ModelType.Document);
    }
}

class NewsPaper extends Model {
    NewsPaper() {
        super(ModelType.NewsPaper);
    }
}

interface StrategyPrinting {
    void setModel(Model model);
    void doPrint();
}

@NoArgsConstructor
class Printer {
    @Getter
    @Setter
    private Model model;
}

@Log4j2
class PrinterPhoto extends Printer implements StrategyPrinting {
    @Override
    public void doPrint() {
        log.info("Printing " + super.getModel().getType().name());
    }
}

@Log4j2
class PrinterDocument extends Printer implements StrategyPrinting {
    @Override
    public void doPrint() {
        log.info("Printing " + getModel().getType().name());
    }
}
