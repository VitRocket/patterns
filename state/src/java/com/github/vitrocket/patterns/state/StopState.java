package com.github.vitrocket.patterns.state;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StopState implements State {

    public void doAction(Context context) {
        log.info("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}
