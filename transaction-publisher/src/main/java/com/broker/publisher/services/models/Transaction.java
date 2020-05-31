package com.broker.publisher.services.models;

import com.broker.publisher.services.models.enums.Currency;
import com.broker.publisher.services.models.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
    private String transactionCode;
    private TransactionType type;
    private LocalDateTime happenedOn;
    private BigDecimal transactionValue;
    private Currency currency;
}
