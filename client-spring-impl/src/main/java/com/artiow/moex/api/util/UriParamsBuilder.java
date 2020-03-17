package com.artiow.moex.api.util;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class UriParamsBuilder {

    private final Map<String, String> map;


    private UriParamsBuilder(int initialCapacity) {
        this.map = new HashMap<>(initialCapacity);
    }


    public static UriParamsBuilder uriParamsBuilder(int initialCapacity) {
        return new UriParamsBuilder(initialCapacity);
    }


    public UriParamsBuilder set(String parameter, Object value) {
        Assert.notNull(parameter, "URI parameter cannot be null!");
        Assert.notNull(value, "URI parameter value cannot be null!");
        map.put(parameter, value.toString());
        return this;
    }

    public Map<String, String> build() {
        return map;
    }
}
