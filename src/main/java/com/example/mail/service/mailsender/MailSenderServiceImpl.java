package com.example.mail.service.mailsender;

import com.example.mail.dto.SendMailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailSenderServiceImpl implements MailSenderService {

    private static final String FROM = "esersuleyman96@hotmail.com";

    private final JavaMailSender mailSender;

    @Override
    public void sendMail(SendMailDTO sendMailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM);
        message.setSubject(sendMailDTO.getSubject());
        message.setText(LocalDate.now().toString() + " - " + sendMailDTO.getBody());
        message.setTo(sendMailDTO.getToEMail());
        mailSender.send(message);
        log.info("Mail sent successfully.");
    }
}
