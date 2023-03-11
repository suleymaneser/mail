package com.example.mail.service.mailsender;

import com.example.mail.dto.SendMailDTO;

public interface MailSenderService {

    void sendMail(SendMailDTO sendMailDTO);
}
