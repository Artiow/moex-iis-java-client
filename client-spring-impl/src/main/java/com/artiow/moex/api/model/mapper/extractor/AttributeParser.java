package com.artiow.moex.api.model.mapper.extractor;

import lombok.val;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static org.springframework.util.StringUtils.hasText;

public class AttributeParser {

    private static final DateTimeFormatter LOCAL_DATE_FORMATTER;
    private static final DateTimeFormatter LOCAL_TIME_FORMATTER;
    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER;

    static {
        LOCAL_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
        LOCAL_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;
        LOCAL_DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
    }


    private final Map<Class<? extends Serializable>, Function<String, ? extends Serializable>> rules;


    public AttributeParser() {
        val rules = new HashMap<Class<? extends Serializable>, Function<String, ? extends Serializable>>();
        rules.put(Boolean.class, this::parseBoolean);
        rules.put(Number.class, this::parseNumber);
        rules.put(Integer.class, this::parseInteger);
        rules.put(Long.class, this::parseLong);
        rules.put(Double.class, this::parseDouble);
        rules.put(String.class, this::parseString);
        rules.put(LocalDate.class, this::parseDate);
        rules.put(LocalTime.class, this::parseTime);
        rules.put(LocalDateTime.class, this::parseDatetime);
        this.rules = rules;
    }


    private static IllegalArgumentException exceptionFor(String value, Class<?> type, Throwable cause) {
        val msg = format("Cannot parse \"%s\" to %s!", value, type.getName());
        return cause != null ? new IllegalArgumentException(msg, cause) : new IllegalArgumentException(msg);
    }


    public <T extends Serializable> T parse(String value, Class<T> type) {
        return hasText(value) ? getParseRule(type).apply(value) : null;
    }


    private <T extends Serializable> Function<String, T> getParseRule(Class<T> type) {
        // noinspection unchecked
        return ofNullable((Function<String, T>) rules.get(type))
                .orElseThrow(() -> new IllegalArgumentException("There is no parser for " + type.getName()));
    }


    private Boolean parseBoolean(String attribute) {
        if (attribute.equalsIgnoreCase("true")) return true;
        if (attribute.equalsIgnoreCase("false")) return false;
        if (attribute.equalsIgnoreCase("1")) return true;
        if (attribute.equalsIgnoreCase("0")) return false;
        throw exceptionFor(attribute, Boolean.class, null);
    }

    private Number parseNumber(String attribute) {
        try {
            return NumberFormat.getInstance(Locale.US).parse(attribute);
        } catch (Exception e) {
            throw exceptionFor(attribute, Number.class, e);
        }
    }

    private Integer parseInteger(String attribute) {
        try {
            return Integer.parseInt(attribute);
        } catch (Exception e) {
            throw exceptionFor(attribute, Integer.class, e);
        }
    }

    private Long parseLong(String attribute) {
        try {
            return Long.parseLong(attribute);
        } catch (Exception e) {
            throw exceptionFor(attribute, Long.class, e);
        }
    }

    private Double parseDouble(String attribute) {
        try {
            return Double.parseDouble(attribute);
        } catch (Exception e) {
            throw exceptionFor(attribute, Double.class, e);
        }
    }

    private String parseString(String attribute) {
        return attribute;
    }

    private LocalDate parseDate(String attribute) {
        try {
            return LocalDate.parse(attribute, LOCAL_DATE_FORMATTER);
        } catch (Exception e) {
            throw exceptionFor(attribute, LocalDate.class, e);
        }
    }

    private LocalTime parseTime(String attribute) {
        try {
            return LocalTime.parse(attribute, LOCAL_TIME_FORMATTER);
        } catch (Exception e) {
            throw exceptionFor(attribute, LocalTime.class, e);
        }
    }

    private LocalDateTime parseDatetime(String attribute) {
        try {
            return LocalDateTime.parse(attribute, LOCAL_DATE_TIME_FORMATTER);
        } catch (Exception e) {
            throw exceptionFor(attribute, LocalDateTime.class, e);
        }
    }
}
