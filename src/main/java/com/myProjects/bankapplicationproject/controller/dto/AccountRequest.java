package com.myProjects.bankapplicationproject.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountRequest {
    private String currency;
    private BigDecimal balance;
    private Long clientId;
}
