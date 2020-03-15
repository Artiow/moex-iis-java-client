package com.artiow.moex.api.util;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public class UriParamsBuilder {

    private final Map<String, String> map;


    private UriParamsBuilder(int initialCapacity) {
        this.map = new HashMap<>(initialCapacity);
    }


    public static UriParamsBuilder uriParamsBuilder(int initialCapacity) {
        return new UriParamsBuilder(initialCapacity);
    }


    public UriParamsBuilder set(String parameter, Object value) {
        if (nonNull(parameter) && nonNull(value)) {
            map.put(parameter, value.toString());
        }
        return this;
    }

    public Map<String, String> build() {
        return map;
    }
}
