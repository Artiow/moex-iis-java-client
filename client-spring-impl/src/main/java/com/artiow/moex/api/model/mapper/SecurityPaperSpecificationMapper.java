package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.SecurityPaperSpecification;
import com.artiow.moex.api.model.mapper.data.SecurityPaperBoardDataMapper;
import com.artiow.moex.api.model.mapper.data.SecurityPaperDescriptionDataMapper;
import com.artiow.moex.api.model.schema.Data;
import lombok.var;

import java.util.Map;

public class SecurityPaperSpecificationMapper extends AbstractDocumentMapper<SecurityPaperSpecification> {

    private final SecurityPaperBoardDataMapper boardDataMapper;
    private final SecurityPaperDescriptionDataMapper descriptionDataMapper;

    public SecurityPaperSpecificationMapper() {
        this.boardDataMapper = new SecurityPaperBoardDataMapper();
        this.descriptionDataMapper = new SecurityPaperDescriptionDataMapper();
    }

    @Override
    protected SecurityPaperSpecification map(Map<String, Data> data) {
        var result = new SecurityPaperSpecification();
        result.setBoards(boardDataMapper.map(data.get("boards")));
        result.setDescription(descriptionDataMapper.map(data.get("description")));
        return result;
    }
}
