package com.broker.consumer.services.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ITransactionConsumer {
    String INPUT = "transactions";

    @Input(ITransactionConsumer.INPUT)
    SubscribableChannel incomingMessage();
}
