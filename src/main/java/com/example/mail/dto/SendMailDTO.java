package com.example.mail.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class SendMailDTO {

    private String subject;

    private String body;

    private String toEMail;

}
