package com.springpracticesdemo.serialization;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.springpracticesdemo.exception.BadRequestException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    public static final int MINIMUM_DATE_LENGTH = 10;

    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = p.getText();

        if (date != null && date.length() >= MINIMUM_DATE_LENGTH) {
            try {
                return LocalDate.parse(date.substring(0, MINIMUM_DATE_LENGTH));
            } catch (Exception e) {
                log.error("{} - {}", p.currentName(), e.getMessage(), e);

                throw new BadRequestException(e.getMessage());
            }
        }

        throw new BadRequestException(
            "Invalid format of %s: [%s]".formatted(p.currentName(), date));
    }
}
