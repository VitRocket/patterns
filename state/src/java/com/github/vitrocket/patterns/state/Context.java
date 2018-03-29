package com.github.vitrocket.patterns.state;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
class Context {
    private State state;
}
