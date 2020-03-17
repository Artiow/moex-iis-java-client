package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import com.artiow.moex.api.model.schema.Data;
import com.artiow.moex.api.model.schema.Row;

import java.util.List;

public abstract class AbstractDataMapper<T> implements DataMapper<T> {

    public T map(Data data) {
        return rowMapping(data.getRows(), new AttributeExtractor(data.getMetadata().getColumns()));
    }

    protected abstract T rowMapping(List<Row> rows, AttributeExtractor extractor);
}
