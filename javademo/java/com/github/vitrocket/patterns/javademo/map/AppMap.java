package com.github.vitrocket.patterns.javademo.map;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Log4j2
public class AppMap {

    public static void main(String[] args) {
        log.info("Start!");

        Clothes clothe = new Clothes(1, "thing");
        //clothe.setSize(10);
        AbstractProduct furniture = new Furniture(1, "thing");

        log.info(clothe);
        log.info(furniture);

        log.info(clothe.equals(furniture));
        log.info(clothe.hashCode());
        log.info(furniture.hashCode());

        Set<AbstractProduct> productSet = new HashSet<>();
        productSet.add(clothe);
        productSet.add(furniture);
        log.info(productSet.size());
        log.info(productSet);


        log.info("contains clothe: " + productSet.contains(clothe));
        log.info("contains furniture: " + productSet.contains(furniture));









        log.info("-----------------------------------------------");
        Map<Integer, AbstractProduct> productMap = new HashMap<>();
        productMap.put(clothe.getId(), clothe);
        productMap.put(furniture.getId(), furniture);
        log.info(productMap.size());
        log.info(productMap);


    }
}
