package com.example.prLab9.exceptions;

import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;
import java.time.LocalDate;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class CustomExceptionHandler {
    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<ErrorDetails> handleMessagingException(MessagingException ex, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleFileNotFoundException(FileNotFoundException ex, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(BAD_REQUEST).body(errorDetails);
    }
}
