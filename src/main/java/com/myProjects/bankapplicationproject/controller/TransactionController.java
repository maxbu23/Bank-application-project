package com.myProjects.bankapplicationproject.controller;

import com.myProjects.bankapplicationproject.controller.dto.TransactionRequest;
import com.myProjects.bankapplicationproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    //TODO: @GetMapping

    @PostMapping(path = "api/transaction")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTransaction(@RequestBody() TransactionRequest request){
        service.save(request);
    }

}
