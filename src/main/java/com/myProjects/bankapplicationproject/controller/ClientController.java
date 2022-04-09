package com.myProjects.bankapplicationproject.controller;

import com.myProjects.bankapplicationproject.controller.dto.ClientRequest;
import com.myProjects.bankapplicationproject.controller.dto.ClientResponse;
import com.myProjects.bankapplicationproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path = "api/")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "api/client")
    public ResponseEntity<ClientResponse> findByEmail(@RequestParam() String email){
        final ClientResponse response = clientService.findResponseByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "api/client")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createClient(@RequestBody() ClientRequest clientRequest){
        clientService.save(clientRequest);
    }

}
