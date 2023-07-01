package com.hackathon.sic.exception;

public class IncorrectVerificationCodeException extends Exception {
    @Override
    public String getMessage(){
        return "Неправильный код. Попробуйте снова";
    }
}
