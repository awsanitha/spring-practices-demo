package com.springpracticesdemo.serialization;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    @Serial
    private static final long serialVersionUID = 1395580540249925728L;

    public LocalDateTimeSerializer() {
        super(LocalDateTime.class);
    }

    @Override
    public void serialize(
            final LocalDateTime value, final JsonGenerator generator, final SerializerProvider provider)
            throws IOException {
        if (value != null) {
            final long mills = value.toInstant(ZoneOffset.UTC).toEpochMilli();
            generator.writeNumber(mills);
        } else {
            generator.writeNull();
        }
    }
}
