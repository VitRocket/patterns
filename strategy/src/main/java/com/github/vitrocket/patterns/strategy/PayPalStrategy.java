package com.github.vitrocket.patterns.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Log4j2
@RequiredArgsConstructor
public class PayPalStrategy implements PaymentStrategy {

    private final String emailId;
    private final String password;

    @Override
    public void pay(BigDecimal amount) {
        log.info(amount + " paid using PayPal.");
    }
}
