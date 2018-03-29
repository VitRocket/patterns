package com.github.vitrocket.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class StoreCart {

    List<Product> productList;

    public StoreCart() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
    }

    public void pay(PaymentStrategy paymentMethod) {
        BigDecimal amount = calculateTotal();
        paymentMethod.pay(amount);
    }

    private BigDecimal calculateTotal() {
        BigDecimal result = BigDecimal.ZERO;
        for (Product product : this.productList) {
            result = result.add(product.getPrice());
        }
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
