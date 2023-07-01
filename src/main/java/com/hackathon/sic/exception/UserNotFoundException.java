package com.hackathon.sic.exception;

public class UserNotFoundException extends Exception{
    @Override
    public String getMessage(){
        return "Пользователя с данным адресом электронной почты не существует";
    }
}
