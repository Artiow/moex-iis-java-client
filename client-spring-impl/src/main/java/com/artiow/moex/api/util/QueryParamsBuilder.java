package com.artiow.moex.api.util;

import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static java.util.Objects.nonNull;

public class QueryParamsBuilder {

    private final MultiValueMap<String, String> map;


    private QueryParamsBuilder(int initialCapacity) {
        this.map = new LinkedMultiValueMap<>(initialCapacity);
    }


    public static QueryParamsBuilder queryParamsBuilder(int initialCapacity) {
        return new QueryParamsBuilder(initialCapacity);
    }


    public QueryParamsBuilder set(String parameter, Object value) {
        Assert.notNull(parameter, "Query parameter name cannot be null!");
        if (nonNull(value)) {
            map.set(parameter, value.toString());
        }
        return this;
    }

    public MultiValueMap<String, String> build() {
        return map;
    }
}
