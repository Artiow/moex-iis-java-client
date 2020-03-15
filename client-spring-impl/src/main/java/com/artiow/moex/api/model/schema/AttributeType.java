package com.artiow.moex.api.model.schema;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@RequiredArgsConstructor
public enum AttributeType {

    BOOLEAN("boolean", Boolean.class),
    NUMBER("number", Number.class),
    INT32("int32", Integer.class),
    INT64("int64", Long.class),
    STRING("string", String.class),
    DATE("date", LocalDate.class),
    TIME("time", LocalTime.class),
    DATETIME("datetime", LocalDateTime.class);


    private final String value;
    private final Class<? extends Serializable> type;
}
