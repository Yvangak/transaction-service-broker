package com.broker.consumer.services.interfaces;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface IErrorTransactionProcessor {
    String ERROR_OUTPUT = "transactions.errors";

    @Output(IErrorTransactionProcessor.ERROR_OUTPUT)
    MessageChannel errorHandler();
}
