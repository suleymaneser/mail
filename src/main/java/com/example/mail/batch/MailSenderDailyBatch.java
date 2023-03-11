package com.example.mail.batch;

import com.example.mail.dto.SendMailDTO;
import com.example.mail.service.ReadFile;
import com.example.mail.service.mailsender.MailSenderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderDailyBatch {

    private static final String I_LOVE_YOU = "json/iloveyou.json";

    private final MailSenderService mailSender;

    @SneakyThrows
    private SendMailDTO prepareSendMailDTO(String path) {
        return new ObjectMapper().readValue(ReadFile.readFileContent(path),
                new TypeReference<SendMailDTO>() {
                });
    }

    @Scheduled(cron = "0 1 1 * * *", zone = "Europe/Istanbul")
    public void sendMail() {
        mailSender.sendMail(prepareSendMailDTO(I_LOVE_YOU));
    }
}
