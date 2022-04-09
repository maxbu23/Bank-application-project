package com.myProjects.bankapplicationproject.service;

import com.myProjects.bankapplicationproject.controller.dto.TransactionRequest;
import com.myProjects.bankapplicationproject.model.TransactionEntity;
import com.myProjects.bankapplicationproject.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepo repository;
    private final AccountService accountService;

    @Autowired
    public TransactionService(TransactionRepo repository, AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }


    public void save(TransactionRequest request){
        accountService.transfer(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount());

        repository.save(
                TransactionEntity.builder()
                .amount(request.getAmount())
                .toAccountCurrency(accountService
                        .findById(request
                                .getToAccountId())
                        .getCurrency())
                .fromAccountCurrency(accountService
                        .findById(request
                                .getFromAccountId())
                        .getCurrency())
                .fromAccountId(request.getFromAccountId())
                .toAccountId(request.getToAccountId())
                .transactionDate(LocalDateTime.now())
                .build());
    }
}
