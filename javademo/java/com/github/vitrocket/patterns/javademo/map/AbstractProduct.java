package com.github.vitrocket.patterns.javademo.map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id", "name"})
@RequiredArgsConstructor
public abstract class AbstractProduct {

    @NonNull
    private Integer id;
    @NonNull
    private String name;

}
