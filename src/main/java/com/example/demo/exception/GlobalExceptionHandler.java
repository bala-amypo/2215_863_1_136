package com.example.demo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 400 - Custom bad request
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBad(BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // 404 - Resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    // 400 - Invalid JSON
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidJson(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body("Invalid JSON request body");
    }

    // 400 - Database constraint issues (VERY IMPORTANT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDbError(DataIntegrityViolationException ex) {
        return ResponseEntity.badRequest().body("Database constraint violation");
    }

    // 500 - Catch EVERYTHING else (DEBUG PURPOSE)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAll(Exception ex) {
        ex.printStackTrace(); // 👈 THIS WILL SHOW REAL ERROR IN LOGS
        return ResponseEntity.status(500).body(ex.getMessage());
    }
}
