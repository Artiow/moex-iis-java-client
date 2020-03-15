package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.schema.Data;
import com.artiow.moex.api.model.schema.Document;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractDocumentMapper<T> implements DocumentMapper<T> {

    @Override
    public T map(Document document) {
        return map(document.getData().stream().collect(Collectors.toMap(Data::getId, Function.identity())));
    }

    protected abstract T map(Map<String, Data> data);
}
