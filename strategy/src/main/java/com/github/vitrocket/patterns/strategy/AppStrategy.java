package com.github.vitrocket.patterns.strategy;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Log4j2
public class AppStrategy {

    public static void main(String[] args) {
        StoreCart cart = new StoreCart();

        Product product1 = new Product(123564789L, "Banana", new BigDecimal(2));
        Product product2 = new Product(123562345L, "Apple", new BigDecimal(2.2));

        cart.addProduct(product1);
        cart.addProduct(product2);

        //pay by PayPal
        cart.pay(new PayPalStrategy("emaol@example.com", "password"));

        //pay by Portmone
        cart.pay(new PortmoneStrategy("+80501111111", "passwors", 123456));
    }
}
