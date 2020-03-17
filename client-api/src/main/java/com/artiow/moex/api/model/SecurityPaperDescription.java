package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toMap;
import static lombok.AccessLevel.PRIVATE;

public class SecurityPaperDescription {

    private final Map<SecurityPaperDescriptionKey, SecurityPaperDescriptionValue<?>> map = new HashMap<>();


    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey(SecurityPaperDescriptionKey key) {
        return map.containsKey(key);
    }


    public String getTitle(SecurityPaperDescriptionKey key) {
        return map.get(key).getTitle();
    }

    public Boolean getBoolean(SecurityPaperDescriptionKey key) {
        return get(key, Boolean.class);
    }

    public Number getNumber(SecurityPaperDescriptionKey key) {
        return get(key, Number.class);
    }

    public String getString(SecurityPaperDescriptionKey key) {
        return get(key, String.class);
    }

    public LocalDate getDate(SecurityPaperDescriptionKey key) {
        return get(key, LocalDate.class);
    }

    public LocalTime getTime(SecurityPaperDescriptionKey key) {
        return get(key, LocalTime.class);
    }

    public LocalDateTime getDatetime(SecurityPaperDescriptionKey key) {
        return get(key, LocalDateTime.class);
    }

    private <T extends Serializable> T get(SecurityPaperDescriptionKey key, Class<T> type) {
        if (key.getType() != type) {
            throw new IllegalArgumentException(format("Wrong key type! Expected %s, but found %s", type, key.getType().getName()));
        }
        return type.cast(map.get(key).getValue());
    }


    public Object putValue(SecurityPaperDescriptionKey key, Object value, String title) {
        if (key.getType() != value.getClass()) {
            throw new IllegalArgumentException(format("Wrong value type! Expected %s, but found %s", key.getType().getName(), value.getClass().getName()));
        }
        return ofNullable(map.put(key, new SecurityPaperDescriptionValue<>((Serializable) value, title)))
                .map(SecurityPaperDescriptionValue::getValue)
                .orElse(null);
    }


    public void remove(SecurityPaperDescriptionKey key) {
        map.remove(key);
    }

    public void clear() {
        map.clear();
    }


    public Set<SecurityPaperDescriptionKey> keySet() {
        return map.keySet();
    }


    public Map<SecurityPaperDescriptionKey, String> titleMap() {
        return map(SecurityPaperDescriptionValue::getTitle);
    }

    public Map<SecurityPaperDescriptionKey, Serializable> valueMap() {
        return map(SecurityPaperDescriptionValue::getValue);
    }

    private <T extends Serializable> Map<SecurityPaperDescriptionKey, T> map(Function<SecurityPaperDescriptionValue<?>, T> extractor) {
        return map
                .entrySet()
                .stream()
                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), extractor.apply(e.getValue())))
                .collect(toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return map.equals(((SecurityPaperDescription) o).map);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }


    @Getter(PRIVATE)
    @RequiredArgsConstructor(access = PRIVATE)
    private static class SecurityPaperDescriptionValue<T extends Serializable> {

        private final T value;
        private final String title;
    }
}
