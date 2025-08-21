package com.picketlogia.picket.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        LocalDateTime now = LocalDateTime.now();

        String formatted;
        if (localDateTime.toLocalDate().equals(now.toLocalDate())) {
            // 오늘이면 "오늘 HH:mm"
            formatted = localDateTime.format(DateTimeFormatter.ofPattern("오늘 HH:mm"));
        } else {
            // 오늘이 아니면 "MM.dd HH:mm"
            formatted = localDateTime.format(DateTimeFormatter.ofPattern("MM.dd(E) HH:mm"));
        }

        jsonGenerator.writeString(formatted);
    }
}
