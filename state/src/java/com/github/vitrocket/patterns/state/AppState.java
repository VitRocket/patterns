package com.github.vitrocket.patterns.state;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppState {

    public static void main(String[] args) {
        log.info("Hello");
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        log.info(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        log.info(context.getState().toString());
    }
}
