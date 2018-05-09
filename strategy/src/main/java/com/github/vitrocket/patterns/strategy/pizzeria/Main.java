package com.github.vitrocket.patterns.strategy.pizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by VitRocket on 09.05.2018.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!");
        List<Product> products = new ArrayList<>(Arrays.asList(new HotDog(), new Burger(), new FrenchFrieze()));
        makeProducts(products);
    }

    private static void makeProducts(List<Product> products) {
        MakerFactory makerFactory = new MakerFactory();
        for (Product product : products) {
            try {
                MakerStrategy maker = makerFactory.getMaker(product);
                maker.make();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

class MakerFactory {

    private static Map<ProductType, Supplier<MakerStrategy>> MAKERS = new HashMap<>();

    static {
        MAKERS.put(ProductType.HotDog, MakerHotDog::new);
        MAKERS.put(ProductType.Burger, MakerBurger::new);
        MAKERS.put(ProductType.FrenchFrieze, MakerFrenchFrieze::new);
    }

    MakerStrategy getMaker(Product product) throws Exception {
        Supplier<MakerStrategy> supplier = MAKERS.get(product.getProductType());
        if (supplier != null) {
            MakerStrategy maker = supplier.get();
            maker.setProduct(product);
            return maker;
        }
        throw new Exception("Bad product");
    }
}

interface MakerStrategy {
    void make();
    void setProduct(Product product);
}

abstract class Maker implements MakerStrategy {
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    Product getProduct() {
        return product;
    }
}

class MakerHotDog extends Maker {
    @Override
    public void make() {
        System.out.println("Make " + getProduct().getProductType());
    }
}

class MakerBurger extends Maker {
    @Override
    public void make() {
        System.out.println("Make " + getProduct().getProductType());
    }
}

class MakerFrenchFrieze extends Maker {
    @Override
    public void make() {
        System.out.println("Make " + getProduct().getProductType());
    }
}

enum ProductType {
    HotDog,
    Burger,
    FrenchFrieze
}

abstract class Product {

    private ProductType productType;

    Product(ProductType productType) {
        this.productType = productType;
    }

    ProductType getProductType() {
        return productType;
    }
}

class HotDog extends Product {
    HotDog() {
        super(ProductType.HotDog);
    }
}

class Burger extends Product {
    Burger() {
        super(ProductType.Burger);
    }
}

class FrenchFrieze extends Product {
    FrenchFrieze() {
        super(ProductType.FrenchFrieze);
    }
}
