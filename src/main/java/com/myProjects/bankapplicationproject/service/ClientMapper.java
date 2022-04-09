package com.myProjects.bankapplicationproject.service;

import com.myProjects.bankapplicationproject.controller.dto.ClientRequest;
import com.myProjects.bankapplicationproject.controller.dto.ClientResponse;
import com.myProjects.bankapplicationproject.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientResponse map(Client client){
        return ClientResponse.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .age(client.getAge())
                .accounts(client.getAccounts())
                .build();
    }

    //clientRequest posiada dane ktore sa potrzebne do stworzenia nowego klienta
    public Client map(ClientRequest clientRequest){
        return Client.builder()
                .firstName(clientRequest.getFirstName())
                .lastName(clientRequest.getLastName())
                .email(clientRequest.getEmail())
                .password(clientRequest.getPassword())
                .age(clientRequest.getAge())
                .build();
    }
}
