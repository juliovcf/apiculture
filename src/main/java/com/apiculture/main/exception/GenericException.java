package com.apiculture.main.exception;

public class GenericException extends Exception {

  private final int code;

  public GenericException(int code) {
    super();
    this.code = code;
  }

  public GenericException(String message, int code) {
    super(message);
    this.code = code;
  }

  public GenericException(String message, Exception cause, int code) {
    super(message, cause);
    this.code = code;
  }

  public GenericException(Exception cause, int code) {
    super(cause);
    this.code = code;
  }

  public int getCode() {
    return this.code;
  }

}
