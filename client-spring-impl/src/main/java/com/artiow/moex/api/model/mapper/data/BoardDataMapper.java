package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.Board;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import lombok.val;

public class BoardDataMapper extends AbstractDataStreamMapper<Board> {

    @Override
    protected Board rowMapping(AttributeExtractor.Processor processor) {
        val result = new Board();
        result.setId(processor.readInteger("id"));
        result.setBoardGroupId(processor.readInteger("board_group_id"));
        result.setBoardid(processor.readString("boardid"));
        result.setTitle(processor.readString("title"));
        result.setIsTraded(processor.readBoolean("is_traded"));
        return result;
    }
}
