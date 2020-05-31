package com.broker.publisher.controllers;

import com.broker.publisher.services.TransactionPublisherService;
import com.broker.publisher.services.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/transaction")
public class TransactionController {

    private TransactionPublisherService transactionPublisherService;

    @Autowired
    public TransactionController(TransactionPublisherService transactionPublisherService) {
        this.transactionPublisherService = transactionPublisherService;
    }

    @PostMapping("{transactionCode}/orders")
    public ResponseEntity<String> postTransaction(@PathVariable String transactionCode,
                                                  @Valid @RequestBody Transaction transaction) {
        transaction.setTransactionCode(transactionCode);
        transactionPublisherService.publishMessage(transaction);
        return ResponseEntity.ok("Transaction Posted");
    }

}
