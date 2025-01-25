package com.examples.bsms.exceptionhandler;

import com.examples.bsms.exception.BloodBankNotFoundByIdException;
import com.examples.bsms.exception.UserNotFoundByIdException;
import com.examples.bsms.util.ErrorStructure;
import com.examples.bsms.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class BloodBankExceptionHandler {

    private final RestResponseBuilder responseBuilder;

    public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(BloodBankNotFoundByIdException ex) {
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "BloodBank not found by given Id");
    }
}
