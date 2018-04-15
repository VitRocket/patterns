package com.github.vitrocket.patterns.javademo.concurrency;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class EmailService {

    public Boolean sendMessage(Message message) {
        Boolean status;
        try {
            log.info("Sending..." + message.getMessage());
            message.getMessage().length();
            Thread.sleep(2000);
            log.info("Mail sent to {0}", message);
            status = true;
        } catch (NullPointerException | InterruptedException ex) {
            log.error("Error in sending message.");
            log.error(ex.getMessage());
            status = false;
        }
        return status;
    }
}