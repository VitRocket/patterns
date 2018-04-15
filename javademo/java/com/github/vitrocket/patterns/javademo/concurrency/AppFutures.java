package com.github.vitrocket.patterns.javademo.concurrency;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log4j2
public class AppFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("GET REQUEST");

        MessageService messageService = new MessageService();
        Message message = new Message();
        //message.setMessage("Hello my friend");//TODO you may uncomment for get tru result

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                messageService.sendMessage(message);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
        log.info("SEND RESPONSE");
    }
}
