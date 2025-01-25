package com.examples.bsms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BloodBankNotFoundByIdException extends RuntimeException {
    private final String message;
}
