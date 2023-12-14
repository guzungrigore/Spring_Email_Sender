package com.example.prLab9.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ErrorDetails {
    private LocalDate timeStamp;
    private String message;
    private String description;
}
