package com.example.prLab9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmailRequest {
    private String recipientAddress;
    private String subject;
    private String body;
    private String pathToAttachment;
}

