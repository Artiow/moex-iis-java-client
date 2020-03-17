package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.SecurityPaperSearchResult;
import com.artiow.moex.api.model.mapper.data.SecurityPaperSearchResultDataMapper;
import com.artiow.moex.api.model.schema.Data;

import java.util.List;
import java.util.Map;

public class SecurityPaperSearchResultMapper extends AbstractDocumentMapper<List<SecurityPaperSearchResult>> {

    private final SecurityPaperSearchResultDataMapper dataMapper;

    public SecurityPaperSearchResultMapper() {
        this.dataMapper = new SecurityPaperSearchResultDataMapper();
    }

    @Override
    protected List<SecurityPaperSearchResult> map(Map<String, Data> data) {
        return dataMapper.map(data.get("securities"));
    }
}
