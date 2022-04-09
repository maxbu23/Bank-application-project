package com.myProjects.bankapplicationproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String currency;
    private BigDecimal balance;
    @Column(name = "CLIENT_ID")
    private Long clientId;
}
