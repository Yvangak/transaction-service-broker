package com.broker.consumer.services;

import com.broker.consumer.services.interfaces.IErrorTransactionProcessor;
import com.broker.consumer.services.interfaces.ITransactionConsumer;
import com.broker.consumer.services.models.Transaction;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@EnableBinding({ITransactionConsumer.class, IErrorTransactionProcessor.class})
public class TransactionConsumerService {

    @StreamListener(value = ITransactionConsumer.INPUT,
            condition = "headers['TYPE']=='CASH' || headers['TYPE']=='ASSET'"
    )
    public void processTransaction(Message<Transaction> message) {
        System.out.println("Header"+ message.getHeaders());
        System.out.println("Payload"+ message.getPayload());
        if (message.getPayload().getTransactionCode().equals("TRZ")) {
            throw new RuntimeException("BOOM!!!! Error identified" + message);
        }else{
            System.out.println(">>>>> Transaction handled perfectly: " + message);
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
