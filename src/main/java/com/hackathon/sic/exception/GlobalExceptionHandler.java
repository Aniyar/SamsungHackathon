package com.hackathon.sic.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ UserAlreadyExistsException.class})
    public final ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex){
        ErrorResponse er = new ErrorResponse(ex.getClass().getName(), HttpStatus.NOT_ACCEPTABLE.toString(), ex.getMessage(), null);
        return new ResponseEntity<>(er, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({ IncorrectVerificationCodeException.class})
    public final ResponseEntity<ErrorResponse> handleIncorrectVerificationCodeException(IncorrectVerificationCodeException ex){
        ErrorResponse er = new ErrorResponse(ex.getClass().getName(), HttpStatus.NOT_ACCEPTABLE.toString(), ex.getMessage(), null);
        return new ResponseEntity<>(er, HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler({ UserNotFoundException.class})
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex){
        ErrorResponse er = new ErrorResponse(ex.getClass().getName(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), null);
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({ InstructorNotFoundException.class})
    public final ResponseEntity<ErrorResponse> handleInstructorNotFoundException(InstructorNotFoundException ex){
        ErrorResponse er = new ErrorResponse(ex.getClass().getName(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), null);
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ StudentNotFoundException.class})
    public final ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex){
        ErrorResponse er = new ErrorResponse(ex.getClass().getName(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), null);
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ InstructorNotAuthorizedException.class})
    public final ResponseEntity<ErrorResponse> handleInstructorNotAuthorizedException(InstructorNotAuthorizedException ex){
        ErrorResponse er = new ErrorResponse(ex.getClass().getName(), HttpStatus.NOT_ACCEPTABLE.toString(), ex.getMessage(), null);
        return new ResponseEntity<>(er, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({ GPTNoResponseException.class})
    public final ResponseEntity<ErrorResponse> handleGPTNoResponseException(GPTNoResponseException ex){
        ErrorResponse er = new ErrorResponse(ex.getClass().getName(), HttpStatus.NO_CONTENT.toString(), ex.getMessage(), null);
        return new ResponseEntity<>(er, HttpStatus.NO_CONTENT);
    }



}