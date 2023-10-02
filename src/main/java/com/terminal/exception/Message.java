package com.terminal.exception;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class Message {
    String errorMess;
    String errorCode;

}
