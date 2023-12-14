package com.example.prLab9.service;

import com.example.prLab9.dto.EmailRequest;
import com.example.prLab9.dto.ResponseDto;
import com.example.prLab9.service.api.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    @Override
    public ResponseDto sendEmail(EmailRequest emailRequest) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(emailRequest.getRecipientAddress());
        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getBody());

        if(emailRequest.getPathToAttachment() != null) {
            FileSystemResource file = new FileSystemResource(new File(emailRequest.getPathToAttachment()));
            helper.addAttachment(".txt", file);
        }
        emailSender.send(message);

        return new ResponseDto("Email sent successfully");
    }
}
