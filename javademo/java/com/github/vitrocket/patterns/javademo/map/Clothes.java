package com.github.vitrocket.patterns.javademo.map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Clothes extends AbstractProduct {

    private Integer size;

    public Clothes(Integer id, String name) {
        super(id, name);
    }

}
