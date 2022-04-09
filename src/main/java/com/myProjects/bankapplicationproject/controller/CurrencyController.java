package com.myProjects.bankapplicationproject.controller;

import com.myProjects.bankapplicationproject.controller.dto.CurrencyResponse;
import com.myProjects.bankapplicationproject.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    //TODO: comment method bellow
    //method created to test
//    @GetMapping(path = "api/currency")
//    public ResponseEntity<CurrencyResponse> getCurrencyRates(){
//        final CurrencyResponse currencyResponse = currencyService.getCurrencyResponse("PLN","EUR");
//        return new ResponseEntity<>(currencyResponse, HttpStatus.ACCEPTED);
//    }
}
