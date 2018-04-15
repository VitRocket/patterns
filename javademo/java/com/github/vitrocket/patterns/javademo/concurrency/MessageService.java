package com.github.vitrocket.patterns.javademo.concurrency;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Log4j2
public class MessageService {


    public void sendMessage(Message message) throws ExecutionException, InterruptedException {

        EmailService emailService = new EmailService();
        Callable<Boolean> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return emailService.sendMessage(message);
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Boolean> future = executor.submit(task);

        log.info("future done? " + future.isDone());
        Boolean result = future.get();
        log.info("future done? " + future.isDone());
        log.info("result: " + result);
        executor.shutdown();


    }
}
