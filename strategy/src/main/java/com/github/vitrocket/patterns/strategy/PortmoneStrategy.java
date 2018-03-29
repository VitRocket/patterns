package com.github.vitrocket.patterns.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Log4j2
@RequiredArgsConstructor
public class PortmoneStrategy implements PaymentStrategy {

    private final String phoneId;
    private final String password;
    private final Integer confirmCode;

    @Override
    public void pay(BigDecimal amount) {
        log.info(amount + " paid using Portmone.");
    }
}
