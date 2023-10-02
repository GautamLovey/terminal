package com.terminal.exception;


public class TerminalExceptionHandler extends Exception {
    String errorMess;
    String errorCode;

    public TerminalExceptionHandler(String mess,String code){
      errorMess = mess;
      errorCode = code;

    }

}
