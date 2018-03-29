package com.github.vitrocket.patterns.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
class Product {

    private Long code;
    private String name;
    private BigDecimal price;

}
