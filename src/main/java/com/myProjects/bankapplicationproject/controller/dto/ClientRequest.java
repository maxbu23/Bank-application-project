package com.myProjects.bankapplicationproject.controller.dto;

import lombok.Data;

@Data
public class ClientRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer age;
}
