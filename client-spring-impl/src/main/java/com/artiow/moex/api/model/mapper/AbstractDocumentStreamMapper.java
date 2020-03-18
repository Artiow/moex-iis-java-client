package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.mapper.data.DataStreamMapper;
import com.artiow.moex.api.model.schema.Data;

import java.util.List;
import java.util.Map;

public abstract class AbstractDocumentStreamMapper<T> extends AbstractDocumentMapper<List<T>> implements DocumentStreamMapper<T> {

    private final DataStreamMapper<T> dataMapper;
    private final String mappedDataKey;

    public AbstractDocumentStreamMapper(DataStreamMapper<T> dataMapper, String mappedDataKey) {
        this.dataMapper = dataMapper;
        this.mappedDataKey = mappedDataKey;
    }

    @Override
    protected List<T> map(Map<String, Data> data) {
        return dataMapper.map(data.get(mappedDataKey));
    }
}
