package com.example.prLab9.controller;

import com.example.prLab9.dto.EmailRequest;
import com.example.prLab9.dto.ResponseDto;
import com.example.prLab9.service.api.EmailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class EmailController {
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<ResponseDto> sendEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
        return ResponseEntity.status(OK).body(emailService.sendEmail(emailRequest));
    }
}
