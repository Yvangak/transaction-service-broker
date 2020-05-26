package com.broker.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class TransactionConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionConsumerApplication.class, args);
    }

    @StreamListener(target = Sink.INPUT)
    public void processTransaction(String transaction){
        System.out.println(transaction);
    }
}
