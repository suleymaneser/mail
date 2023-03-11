package com.example.mail.service;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@UtilityClass
@Slf4j
public class ReadFile {

    public String readFileContent(String filePath) {
        StringBuilder responseStrBuilder = new StringBuilder();
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
             InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                responseStrBuilder.append(line);
            }

        } catch (IOException e) {
            log.info(e.toString());
        }
        return responseStrBuilder.toString();
    }

}