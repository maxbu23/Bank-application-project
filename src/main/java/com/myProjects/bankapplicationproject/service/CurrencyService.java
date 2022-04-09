package com.myProjects.bankapplicationproject.service;

import com.myProjects.bankapplicationproject.controller.dto.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class CurrencyService {

    private RestTemplate restTemplate;

    @Autowired
    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrencyResponse getCurrencyResponse(String fromCurrency, String toCurrency){
        String url = "https://api.exchangerate.host/latest?base={base}&symbols={symbols}";
        final HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("base",fromCurrency);
        uriVariables.put("symbols",toCurrency);
        final ResponseEntity<CurrencyResponse> response = restTemplate
                .getForEntity(
                url,
                CurrencyResponse.class,
                uriVariables
        );

        return response.getBody();
    }
}
