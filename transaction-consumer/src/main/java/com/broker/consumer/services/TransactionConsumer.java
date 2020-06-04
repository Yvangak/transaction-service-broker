package com.broker.consumer.services;

import com.broker.consumer.services.interfaces.IErrorTransactionProcessor;
import com.broker.consumer.services.interfaces.ITransactionConsumer;
import com.broker.consumer.services.models.Transaction;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@EnableBinding({ITransactionConsumer.class, IErrorTransactionProcessor.class})
public class TransactionConsumer {

    @StreamListener(value = ITransactionConsumer.INPUT,
            condition = "headers['type']=='CASH'"
    )
    public void processTransaction(Transaction transaction) {
        System.out.println(transaction);
        if (transaction.getTransactionCode().equals("TRZ")) {
            throw new RuntimeException("BOOM!!!! Error identified" + transaction);
        }else{
            System.out.println(">>>>> Transaction handled perfectly: " + transaction);
        }
    }

    @ServiceActivator(inputChannel = ITransactionConsumer.INPUT + ".queueGroup.errors",
            outputChannel = IErrorTransactionProcessor.ERROR_OUTPUT
    )
    public Message<?> handleError(Message<?> error) {
        System.out.println("Handling Error >>>>>> " + error);
        return error;
    }
}
