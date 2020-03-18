package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import com.artiow.moex.api.model.schema.Row;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDataStreamMapper<T> extends AbstractDataMapper<List<T>> implements DataStreamMapper<T> {

    @Override
    protected List<T> rowMapping(List<Row> rows, AttributeExtractor extractor) {
        return rows.stream().map(row -> rowMapping(extractor.process(row))).collect(Collectors.toList());
    }

    protected abstract T rowMapping(AttributeExtractor.Processor processor);
}
