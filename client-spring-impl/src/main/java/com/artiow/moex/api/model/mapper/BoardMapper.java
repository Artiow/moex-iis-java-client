package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.Board;
import com.artiow.moex.api.model.mapper.data.BoardDataMapper;

public class BoardMapper extends AbstractDocumentStreamMapper<Board> {

    public BoardMapper() {
        super(new BoardDataMapper(), "boards");
    }
}
