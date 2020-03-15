package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.schema.Document;

public interface DocumentMapper<T> {

    T map(Document document);
}
