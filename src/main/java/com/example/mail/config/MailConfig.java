package com.example.mail.config;

import com.example.mail.batch.MailSenderDailyBatch;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Import(MailSenderDailyBatch.class)
public class MailConfig {
}
