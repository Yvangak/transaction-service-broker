package com.broker.publisher.services;

import com.broker.publisher.services.interfaces.ITransactionPublisherService;
import com.broker.publisher.services.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(ITransactionPublisherService.class)
public class TransactionPublisherService {

    private ITransactionPublisherService iTransactionPublisherService;

    @Autowired
    public TransactionPublisherService(ITransactionPublisherService iTransactionPublisherService){
        this.iTransactionPublisherService = iTransactionPublisherService;
    }

    public void publishMessage(Transaction transaction){
        iTransactionPublisherService.transactionOrders()
                .send(MessageBuilder
                        .withPayload(transaction)
                        .build());
    }
}
