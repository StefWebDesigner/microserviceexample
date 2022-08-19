package com.MicroservicesSpringExample.exceptions;

import com.MicroservicesSpringExample.exceptions.classExceptions.AdminPrivalgesException;
import com.MicroservicesSpringExample.exceptions.classExceptions.CredentialsException;
import com.MicroservicesSpringExample.exceptions.classExceptions.GeneralException;
import com.MicroservicesSpringExample.exceptions.classExceptions.UserExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(UserExceptions.class)
    public ResponseEntity<String> UserExceptionHandler(UserExceptions e){
        return ResponseEntity.ok(e.getMessage());
    }

    @ExceptionHandler(CredentialsException.class)
    public ResponseEntity<String> CredentialsExceptionHandler(CredentialsException e){
        return ResponseEntity.ok(e.getMessage());
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<String>GeneralExceptionHandler(GeneralException e) {
        return ResponseEntity.ok(e.getMessage());
    }

    @ExceptionHandler(AdminPrivalgesException.class)
    public ResponseEntity<String> AdminPrivalgesExceptionHandler(AdminPrivalgesException e){
        return ResponseEntity.ok(e.getMessage());
    }

}
