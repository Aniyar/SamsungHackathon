package com.hackathon.sic.exception;

public class UserAlreadyExistsException extends Exception {

    @Override
    public String getMessage(){
        return "Пользователь с данным адресом электронной почты уже существует";
    }
}
