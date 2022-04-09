package com.myProjects.bankapplicationproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String fromAccountCurrency;
    private String toAccountCurrency;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private Long fromAccountId;
    private Long toAccountId;
}
