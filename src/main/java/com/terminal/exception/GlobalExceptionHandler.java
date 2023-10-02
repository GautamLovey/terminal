package com.terminal.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TerminalExceptionHandler.class)
    public ResponseEntity<Message> dataNotFound(TerminalExceptionHandler ex){
     Message mess = new Message();
     mess.setErrorMess(ex.errorMess);
     mess.setErrorCode(ex.errorCode);
     return ResponseEntity.ok(mess);
    }
}
