package com.myProjects.bankapplicationproject.controller.dto;

import com.myProjects.bankapplicationproject.model.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private List<Account> accounts;
}
