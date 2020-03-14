package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.*;
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

    public String getString(SecurityPaperDescriptionKey key) {
        return get(key, String.class);
    }

    public Number getNumber(SecurityPaperDescriptionKey key) {
        return get(key, Number.class);
    }

    public Date getDate(SecurityPaperDescriptionKey key) {
        return get(key, Date.class);
    }

    private <T extends Serializable> T get(SecurityPaperDescriptionKey key, Class<T> type) {
        if (key.getType() != type) {
            throw new IllegalArgumentException(format("Wrong key type! Expected %s, but found %s", type, key.getType().getName()));
        }
        return type.cast(map.get(key).getValue());
    }


    public String putString(SecurityPaperDescriptionKey key, String value, String title) {
        return put(key, value, String.class, title);
    }

    public Number putNumber(SecurityPaperDescriptionKey key, Number value, String title) {
        return put(key, value, Number.class, title);
    }

    public Date putDate(SecurityPaperDescriptionKey key, Date value, String title) {
        return put(key, value, Date.class, title);
    }

    private <T extends Serializable> T put(SecurityPaperDescriptionKey key, T value, Class<T> type, String title) {
        if (key.getType() != type) {
            throw new IllegalArgumentException(format("Wrong key type! Expected %s, but found %s", type, key.getType().getName()));
        }
        return ofNullable(map.put(key, new SecurityPaperDescriptionValue<>(value, title)))
                .map(SecurityPaperDescriptionValue::getValue)
                .map(type::cast)
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

    public Map<SecurityPaperDescriptionKey, Object> valueMap() {
        return map(SecurityPaperDescriptionValue::getValue);
    }

    private <T> Map<SecurityPaperDescriptionKey, T> map(Function<SecurityPaperDescriptionValue<?>, T> extractor) {
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
