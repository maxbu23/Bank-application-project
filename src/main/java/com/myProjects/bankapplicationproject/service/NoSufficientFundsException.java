package com.myProjects.bankapplicationproject.service;

public class NoSufficientFundsException extends RuntimeException{
    public NoSufficientFundsException(String message){
        super(message);
    }
}
