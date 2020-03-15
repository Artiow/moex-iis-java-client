package com.artiow.moex.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public final class JsonUtil {

    private static final ObjectWriter WRITER = new ObjectMapper().writerWithDefaultPrettyPrinter();


    public static String asPrettyJsonString(Object value) throws JsonProcessingException {
        return WRITER.writeValueAsString(value);
    }
}
