package com.myProjects.bankapplicationproject.service;

import com.myProjects.bankapplicationproject.controller.dto.ClientRequest;
import com.myProjects.bankapplicationproject.controller.dto.ClientResponse;
import com.myProjects.bankapplicationproject.model.Client;
import com.myProjects.bankapplicationproject.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepo clientRepo;
    private final ClientMapper mapper;

    @Autowired
    public ClientService(ClientRepo clientRepo, ClientMapper mapper) {
        this.clientRepo = clientRepo;
        this.mapper = mapper;
    }

    public ClientResponse findResponseByEmail(String email) {
        final Client client = findByEmail(email);
        return mapper.map(client);
    }

    private Client findByEmail(String email){
        return clientRepo.findClientByEmail(email);
    }

    public void save(ClientRequest clientRequest) {
        if(checkEmail(clientRequest.getEmail())){
            final Client client = mapper.map(clientRequest);
            clientRepo.save(client);
        }else{
            throw new IllegalArgumentException("This email is already exist");
        }

    }
    private boolean checkEmail(String email){
        final Client client = clientRepo.findClientByEmail(email);
        return client == null;
    }


}


