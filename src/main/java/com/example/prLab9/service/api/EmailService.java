package com.example.prLab9.service.api;

import com.example.prLab9.dto.EmailRequest;
import com.example.prLab9.dto.ResponseDto;
import jakarta.mail.MessagingException;

public interface EmailService {
    ResponseDto sendEmail(EmailRequest emailRequest) throws MessagingException;
}
