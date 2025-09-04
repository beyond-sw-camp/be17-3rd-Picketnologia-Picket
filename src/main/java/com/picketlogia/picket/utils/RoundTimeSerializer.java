package com.picketlogia.picket.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RoundTimeSerializer extends JsonSerializer<LocalTime> {
    @Override
    public void serialize(LocalTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String formatted = localDateTime.format(DateTimeFormatter.ofPattern("HH시 mm분"));
        jsonGenerator.writeString(formatted);
    }
}
