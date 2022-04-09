package com.myProjects.bankapplicationproject.controller;

import com.myProjects.bankapplicationproject.controller.dto.AccountRequest;
import com.myProjects.bankapplicationproject.controller.dto.AccountResponse;
import com.myProjects.bankapplicationproject.model.Account;
import com.myProjects.bankapplicationproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping(path = "api/account")
    public ResponseEntity<AccountResponse> findById(@RequestParam() Long id){
        final AccountResponse response = service.findById(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "api/account")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody() AccountRequest accountRequest){
        service.save(accountRequest);
    }
}
