package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.SecurityPaperSearchResult;
import com.artiow.moex.api.model.mapper.table.SecurityPaperSearchResultTableMapper;
import com.artiow.moex.api.model.schema.Data;

import java.util.List;
import java.util.Map;

public class SecurityPaperSearchResultMapper extends AbstractDocumentMapper<List<SecurityPaperSearchResult>> {

    private final SecurityPaperSearchResultTableMapper tableMapper;

    public SecurityPaperSearchResultMapper() {
        this.tableMapper = new SecurityPaperSearchResultTableMapper();
    }

    @Override
    protected List<SecurityPaperSearchResult> map(Map<String, Data> data) {
        return tableMapper.map(data.get("securities"));
    }
}
