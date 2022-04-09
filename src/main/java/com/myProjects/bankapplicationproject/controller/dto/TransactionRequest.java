package com.myProjects.bankapplicationproject.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

    private BigDecimal amount;
    private Long fromAccountId;
    private Long toAccountId;

}
