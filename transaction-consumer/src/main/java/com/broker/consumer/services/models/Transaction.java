package com.broker.consumer.services.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.broker.consumer.services.models.enums.Currency;
import com.broker.consumer.services.models.enums.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
    private String transactionCode;
    private TransactionType type;
    private LocalDateTime happenedOn;
    private BigDecimal transactionValue;
    private Currency currency;
}
