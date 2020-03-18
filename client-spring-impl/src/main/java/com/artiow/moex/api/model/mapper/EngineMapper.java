package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.Engine;
import com.artiow.moex.api.model.mapper.data.EngineDataMapper;

public class EngineMapper extends AbstractDocumentStreamMapper<Engine> {

    public EngineMapper() {
        super(new EngineDataMapper(), "engines");
    }
}
