package com.artiow.moex.api.util;

import com.artiow.moex.api.model.SecurityPaperDescription;
import com.artiow.moex.api.model.SecurityPaperDescriptionKey;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public final class JsonUtil {

    private static final ObjectWriter WRITER;

    static {
        WRITER = new ObjectMapper()
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule())
                .registerModule(new SimpleModule()
                        .addSerializer(SecurityPaperDescription.class, new JsonSerializer<SecurityPaperDescription>() {
                            @Override
                            public void serialize(SecurityPaperDescription value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                                gen.writeStartObject();
                                gen.writeObjectField("valueMap", value.valueMap());
                                gen.writeObjectField("titleMap", value.titleMap());
                                gen.writeEndObject();
                            }
                        })
                        .addKeySerializer(SecurityPaperDescriptionKey.class, new JsonSerializer<SecurityPaperDescriptionKey>() {
                            @Override
                            public void serialize(SecurityPaperDescriptionKey value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                                gen.writeFieldName(value.name());
                            }
                        })
                )
                .writerWithDefaultPrettyPrinter();
    }


    public static String asPrettyJsonString(Object value) throws JsonProcessingException {
        return WRITER.writeValueAsString(value);
    }
}
