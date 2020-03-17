package com.artiow.moex.api.model.mapper.extractor;

import com.artiow.moex.api.model.schema.AttributeType;
import com.artiow.moex.api.model.schema.Column;
import com.artiow.moex.api.model.schema.Row;
import lombok.RequiredArgsConstructor;
import lombok.val;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

public class AttributeExtractor {

    private static final Map<String, AttributeType> TYPE_MAP;

    static {
        TYPE_MAP = Collections.unmodifiableMap(Arrays.stream(AttributeType.values()).collect(Collectors.toMap(
                AttributeType::getValue,
                Function.identity()
        )));
    }


    private final AttributeParser attributeParser;

    private final Map<QName, AttributeType> columnTypeMap;


    public AttributeExtractor(List<Column> columns) {
        this.attributeParser = new AttributeParser();
        this.columnTypeMap = columns.stream().collect(Collectors.toMap(
                Column::getName,
                column -> getType(column.getType())
        ));
    }


    public Processor process(Row row) {
        val unspecifiedAttributes = getUnspecifiedAttributes(row);
        if (!unspecifiedAttributes.isEmpty()) {
            throw new IllegalArgumentException("Next row attributes are not specified: " + unspecifiedAttributes.toString());
        }
        return new Processor(row);
    }

    private Set<QName> getUnspecifiedAttributes(Row row) {
        val set = new HashSet<>(row.getAttributes().keySet());
        set.removeAll(columnTypeMap.keySet());
        return set;
    }


    private AttributeType getType(String value) {
        return ofNullable(TYPE_MAP.get(value))
                .orElseThrow(() -> new IllegalArgumentException(format("There is no \"%s\" attribute type", value)));
    }


    @RequiredArgsConstructor(access = PRIVATE)
    public class Processor {

        private final Map<QName, String> attributes;


        public Processor(Row row) {
            this.attributes = row.getAttributes();
        }


        public AttributeExtractor release() {
            return AttributeExtractor.this;
        }

        public Processor process(Row row) {
            return release().process(row);
        }


        public Boolean readBoolean(String attribute) {
            return read(attribute, Boolean.class);
        }

        public Number readNumber(String attribute) {
            return read(attribute, Number.class);
        }

        public Integer readInteger(String attribute) {
            return read(attribute, Integer.class);
        }

        public Long readLong(String attribute) {
            return read(attribute, Long.class);
        }

        public String readString(String attribute) {
            return read(attribute, String.class);
        }

        public LocalDate readDate(String attribute) {
            return read(attribute, LocalDate.class);
        }

        public LocalTime readTime(String attribute) {
            return read(attribute, LocalTime.class);
        }

        public LocalDateTime readDatetime(String attribute) {
            return read(attribute, LocalDateTime.class);
        }


        public <T extends Serializable> T read(String attribute, Class<T> type) {
            val qname = QName.valueOf(attribute);
            if (!attributes.containsKey(qname)) {
                throw new IllegalArgumentException(format("Processed row does not contain \"%s\" attribute", attribute));
            }
            return attributeParser.parse(attributes.get(qname), type);
        }
    }
}
