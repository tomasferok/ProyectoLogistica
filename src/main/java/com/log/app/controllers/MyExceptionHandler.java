package com.log.app.controllers;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception ex) {
        Logger.getLogger("MyLogger").severe(ex.getMessage());
        return ex.getMessage() != null ? ResponseEntity.badRequest().body(ex.getMessage()) : ResponseEntity.badRequest().body("Error");
    }
}
