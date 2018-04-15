package com.github.vitrocket.patterns.javademo.map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Furniture extends AbstractProduct {

    private Integer size;

    public Furniture(Integer id, String name) {
        super(id, name);
    }

}
