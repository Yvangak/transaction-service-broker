package com.broker.publisher.services;

import com.broker.publisher.services.interfaces.ITransactionPublisherService;
import com.broker.publisher.services.models.Transaction;
import com.broker.publisher.services.models.enums.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@EnableBinding(ITransactionPublisherService.class)
public class TransactionPublisherService {

    private ITransactionPublisherService iTransactionPublisherService;

    @Autowired
    public TransactionPublisherService(ITransactionPublisherService iTransactionPublisherService){
        this.iTransactionPublisherService = iTransactionPublisherService;
    }

    public void publishMessage(Transaction transaction){
        Message<Transaction> message = MessageBuilder
                .withPayload(transaction)
                .setHeader("type", TransactionType.CASH)
                .build();
        iTransactionPublisherService.transactionOrders()
                .send(message);
    }
}
