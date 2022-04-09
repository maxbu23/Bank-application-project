package com.myProjects.bankapplicationproject.service;

import com.myProjects.bankapplicationproject.controller.dto.AccountRequest;
import com.myProjects.bankapplicationproject.controller.dto.AccountResponse;
import com.myProjects.bankapplicationproject.controller.dto.CurrencyResponse;
import com.myProjects.bankapplicationproject.model.Account;
import com.myProjects.bankapplicationproject.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
public class AccountService {

    private final AccountRepo accountRepo;
    private final CurrencyService currencyService;

    @Autowired
    public AccountService(AccountRepo accountRepo, CurrencyService currencyService) {

        this.accountRepo = accountRepo;
        this.currencyService = currencyService;
    }

    public void save(AccountRequest accountRequest){
        accountRepo.save(Account.builder()
                .currency(accountRequest.getCurrency())
                .balance(accountRequest.getBalance())
                .clientId(accountRequest.getClientId())
                .build());
    }

    public AccountResponse findById(Long id){
        return accountRepo.findById(id)
                .map(account -> AccountResponse.builder()
                 .id(account.getId())
                .currency(account.getCurrency())
                .balance(account.getBalance())
                .clientId(account.getClientId()).build())
                .orElseThrow(() -> new NoSuchElementException("Account with "+id+" not found"));
    }

    public void transfer(Long fromId, Long toId, BigDecimal amount){
        if(amount.doubleValue() <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if(fromId.equals(toId)){
            throw new IllegalArgumentException("fromId and toId cannot be equal");
        }
        Account fromAccount = accountRepo.getOne(fromId);
        Account toAccount = accountRepo.getOne(toId);

        if(fromAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0){
            throw new NoSufficientFundsException("Not enough funds");
        }
        final CurrencyResponse currencyResponse = currencyService.getCurrencyResponse(fromAccount.getCurrency(), toAccount.getCurrency());
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        BigDecimal valueToAdd = amount.multiply(currencyResponse.getRates().get(toAccount.getCurrency()));
        toAccount.setBalance(toAccount.getBalance().add(valueToAdd));


        accountRepo.save(toAccount);
        accountRepo.save(fromAccount);
    }
}
