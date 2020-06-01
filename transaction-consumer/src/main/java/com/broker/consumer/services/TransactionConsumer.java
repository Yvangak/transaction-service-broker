package com.broker.consumer.services;

import com.broker.consumer.services.interfaces.ITransactionConsumer;
import com.broker.consumer.services.models.Transaction;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(ITransactionConsumer.class)
public class TransactionConsumer {

    @StreamListener(value = ITransactionConsumer.INPUT, condition = "headers['type']=='MULTI_ASSET'")
    public void processTransaction(Transaction transaction) {
        System.out.println(transaction);
    }
}
