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
        StrategyPrint printer = factory.getPrinter(new Photo());
        printer.print();

        printer = factory.getPrinter(new Document());
        printer.print();

        try {
            printer = factory.getPrinter(new NewsPaper());
            printer.print();
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }
    }
}

class StrategyPrintFactory {

    private static Map<String, Supplier<StrategyPrint>> map = new HashMap<>();

    static {
        map.put("PHOTO", PrintPhoto::new);
        map.put("DOCUMENT", PrintDocument::new);
    }

    StrategyPrint getPrinter(Model model) {
        Supplier<StrategyPrint> supplier = map.get(model.getType().name().toUpperCase());
        if (supplier != null) {
            StrategyPrint printer = supplier.get();
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

interface StrategyPrint {
    void setModel(Model model);
    void print();
}

@NoArgsConstructor
class Print {
    @Getter
    @Setter
    private Model model;
}

@Log4j2
class PrintPhoto extends Print implements StrategyPrint {
    @Override
    public void print() {
        log.info("Printing " + super.getModel().getType().name());
    }
}

@Log4j2
class PrintDocument extends Print implements StrategyPrint {
    @Override
    public void print() {
        log.info("Printing " + getModel().getType().name());
    }
}
