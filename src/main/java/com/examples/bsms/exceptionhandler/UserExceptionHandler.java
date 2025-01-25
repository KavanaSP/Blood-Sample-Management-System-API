package com.examples.bsms.exceptionhandler;

import com.examples.bsms.exception.UserNotFoundByIdException;
import com.examples.bsms.util.ErrorStructure;
import com.examples.bsms.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {

    private final RestResponseBuilder responseBuilder;

    public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(UserNotFoundByIdException ex) {
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "User not found by given Id");
    }

    public ResponseEntity<ErrorStructure<String>>  handleUserNotFoundByName(UsernameNotFoundException ex) {
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"User not found by given name");
    }

}
