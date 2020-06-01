package com.broker.publisher.services.interfaces;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ITransactionPublisherService {
    String OUTPUT = "transactions";

    @Output(ITransactionPublisherService.OUTPUT)
    MessageChannel transactionOrders();
}
