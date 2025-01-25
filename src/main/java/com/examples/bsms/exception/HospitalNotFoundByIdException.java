package com.examples.bsms.exception;

public class HospitalNotFoundByIdException extends RuntimeException {
  public HospitalNotFoundByIdException(String message) {
    super(message);
  }
}
