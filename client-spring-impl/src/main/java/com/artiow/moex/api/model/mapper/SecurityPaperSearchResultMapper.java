package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.SecurityPaperSearchResult;
import com.artiow.moex.api.model.mapper.data.SecurityPaperSearchResultDataMapper;

public class SecurityPaperSearchResultMapper extends AbstractDocumentStreamMapper<SecurityPaperSearchResult> {

    public SecurityPaperSearchResultMapper() {
        super(new SecurityPaperSearchResultDataMapper(), "securities");
    }
}
