package com.examples.bsms.exception;

public class UserNotFoundByIdException extends RuntimeException {
  public UserNotFoundByIdException(String message) {
    super(message);
  }
}
