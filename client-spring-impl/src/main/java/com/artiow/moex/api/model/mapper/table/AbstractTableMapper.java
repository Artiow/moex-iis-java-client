package com.artiow.moex.api.model.mapper.table;

import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import com.artiow.moex.api.model.schema.Data;
import lombok.val;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTableMapper<T> implements TableMapper<T> {

    public List<T> map(Data data) {
        val extractor = new AttributeExtractor(data.getMetadata().getColumns());
        return data.getRows().stream().map(row -> rowMapping(extractor.process(row))).collect(Collectors.toList());
    }

    protected abstract T rowMapping(AttributeExtractor.Processor processor);
}
