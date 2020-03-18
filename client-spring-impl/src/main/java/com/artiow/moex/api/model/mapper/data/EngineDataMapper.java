package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.Engine;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import lombok.val;

public class EngineDataMapper extends AbstractDataStreamMapper<Engine> {

    @Override
    protected Engine rowMapping(AttributeExtractor.Processor processor) {
        val result = new Engine();
        result.setId(processor.readInteger("id"));
        result.setName(processor.readString("name"));
        result.setTitle(processor.readString("title"));
        return result;
    }
}
