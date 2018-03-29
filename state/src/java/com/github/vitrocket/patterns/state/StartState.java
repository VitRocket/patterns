package com.github.vitrocket.patterns.state;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StartState implements State {

    public void doAction(Context context) {
        log.info("Player is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}
